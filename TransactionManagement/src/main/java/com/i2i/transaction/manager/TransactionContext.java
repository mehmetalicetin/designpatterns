package com.i2i.transaction.manager;

import com.i2i.transaction.config.ConfigurationProperties;
import com.i2i.transaction.config.ConnectionManager;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class TransactionContext implements AutoCloseable{
	private final Connection connection;

	private TransactionContext() throws SQLException {
		ConnectionManager connectionManager = ConnectionManager.create(ConfigurationProperties.getInstance());
		connection = connectionManager.getConnection();
	}

	public static TransactionContext create() throws SQLException {
		return new TransactionContext();
	}

	public void commit() throws SQLException {
		connection.commit();
	}

	public void rollback() throws SQLException {
		connection.rollback();
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
