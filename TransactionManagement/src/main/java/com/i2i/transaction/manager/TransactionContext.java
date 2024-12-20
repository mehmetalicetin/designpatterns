package com.i2i.transaction.manager;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class TransactionContext {
	private final Connection connection;

	public TransactionContext() throws SQLException {
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
}
