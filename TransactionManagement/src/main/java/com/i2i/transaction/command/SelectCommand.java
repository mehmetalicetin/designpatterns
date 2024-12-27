package com.i2i.transaction.command;

import com.i2i.transaction.query.LogQueries;
import com.i2i.transaction.query.TransactionStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SelectCommand implements DatabaseCommand {
	private final TransactionStatement transactionStatement;
	private final ResultProcessor processor;

	public SelectCommand(TransactionStatement transactionStatement, ResultProcessor resultProcessor) {
		this.transactionStatement = transactionStatement;
		this.processor = resultProcessor;
	}

	@Override
	public void execute(LogQueries logQueries) throws SQLException {
		validate(logQueries);
		long startTime = System.currentTimeMillis();
		long elapsedTime;
		try (ResultSet resultSet = getPreparedStatement().executeQuery()) {
			processor.process(resultSet);
			elapsedTime = System.currentTimeMillis() - startTime;
			transactionStatement.setElapsedTime(elapsedTime);
			logQueries.logExecutedQuery(transactionStatement);
		}
	}


	@Override
	public void rollback(LogQueries logQueries) throws SQLException {
		validate(logQueries);
		logQueries.logFailedQuery(transactionStatement);
	}

	private PreparedStatement getPreparedStatement() {
		return transactionStatement.getStatement();
	}

	private void validate(LogQueries logQueries) {
		Objects.requireNonNull(logQueries, "logQueries cannot be null");
		Objects.requireNonNull(transactionStatement, "TransactionStatement cannot be null");
	}
}
