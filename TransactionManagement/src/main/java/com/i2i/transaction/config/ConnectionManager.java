package com.i2i.transaction.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements IConnection{
	private final Connection connection;

	private ConnectionManager(ConfigurationProperties properties) throws SQLException {
		this.connection = DriverManager.getConnection(properties.getUrl(), properties.getUsername(), properties.getPassword());
		this.connection.setAutoCommit(false);
	}
	public static ConnectionManager create(ConfigurationProperties properties) throws SQLException {
		return new ConnectionManager(properties);
	}
	@Override
	public Connection getConnection() {
		return connection;
	}
}
