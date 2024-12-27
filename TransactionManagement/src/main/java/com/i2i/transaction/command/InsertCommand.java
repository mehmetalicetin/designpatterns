package com.i2i.transaction.command;

import com.i2i.transaction.query.LogQueries;
import com.i2i.transaction.query.TransactionStatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class InsertCommand implements DatabaseCommand{
	private final TransactionStatement transactionStatement;

	private InsertCommand(TransactionStatement transactionStatement) {
		this.transactionStatement = transactionStatement;
	}

	public static InsertCommand create(TransactionStatement statement) {
		return new InsertCommand(statement);
	}

	@Override
	public void execute(LogQueries logQueries) throws SQLException {
		validate(logQueries);
		long startTime = System.currentTimeMillis();
		getPreparedStatement().executeBatch();
		long elapsedTime = System.currentTimeMillis() - startTime;
		transactionStatement.setElapsedTime(elapsedTime);
		logQueries.logExecutedQuery(transactionStatement);
	}

	private PreparedStatement getPreparedStatement() {
		return transactionStatement.getStatement();
	}

	@Override
	public void rollback(LogQueries logQueries) {
		validate(logQueries);
		logQueries.logFailedQuery(transactionStatement);
	}

	private void validate(LogQueries logQueries) {
		Objects.requireNonNull(logQueries, "logQueries cannot be null");
		Objects.requireNonNull(transactionStatement, "TransactionStatement cannot be null");
	}
}
