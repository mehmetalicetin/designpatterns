package com.i2i.transaction.manager;

import com.i2i.transaction.query.LogQueries;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionContext {
	@Getter
	private final Connection connection;
	private final LogQueries logQueries;

	public TransactionContext(LogQueries logQueries) throws SQLException {
		this.logQueries = logQueries;
		connection = DriverManager.getConnection("");
		connection.setAutoCommit(false); // Begin transaction
	}

	public void commit() throws SQLException {
		connection.commit();
	}

	public void rollback() throws SQLException {
		connection.rollback();
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public LogQueries getLogTransactions() {
		return logQueries;
	}
}
