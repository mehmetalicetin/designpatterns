package com.i2i.transaction.query;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public final class TransactionStatement {
	private final long id = UUID.randomUUID().getMostSignificantBits();
	private List<Query>             queries = new ArrayList<>();
	private final PreparedStatement statement;
	@Setter
	private long elapsedTime;

	private TransactionStatement(Query query, Connection connection) throws SQLException {
		this.queries.add(query);
		Objects.requireNonNull(query, "query cannot be null");
		this.statement = connection.prepareStatement(query.getSql());
		arrangeStatements(query);
	}

	public TransactionStatement(PreparedStatement preparedStatement) {
		this.statement = preparedStatement;
	}

	public void addBatch(Query query) throws SQLException {
		this.queries.add(query);
		arrangeStatements(query);
		this.statement.addBatch();
	}

	public static TransactionStatement create(PreparedStatement preparedStatement) {
		return new TransactionStatement(preparedStatement);
	}

	public static TransactionStatement create(Query query, Connection connection) throws SQLException {
		return new TransactionStatement(query, connection);
	}

	public void arrangeStatements(Query query) throws SQLException {
		Object[] fields = query.getFields();
		for (int i = 0; i < fields.length; i++) {
			setParameterToPreparedStatement(this.statement, i+1, fields[i]);
		}
	}

	private void setParameterToPreparedStatement(PreparedStatement ps, int index, Object param)
			throws SQLException {
		if (param == null) {
			setNullParameter(ps, index);
		} else if (param instanceof Integer) {
			ps.setInt(index, (int) param);
		} else if (param instanceof Long) {
			ps.setLong(index, (long) param);
		} else if (param instanceof Float) {
			ps.setFloat(index, (Float) param);
		} else if (param instanceof Double) {
			ps.setDouble(index, (Double) param);
		} else if (param instanceof Boolean) {
			ps.setBoolean(index, (Boolean) param);
		} else if (param instanceof String) {
			ps.setString(index, (String) param);
		} else if (param instanceof Timestamp) {
			ps.setTimestamp(index, (Timestamp) param);
		} else if (param instanceof BigDecimal) {
			ps.setBigDecimal(index, (BigDecimal) param);
		}
	}

	private void setNullParameter(PreparedStatement ps, int index) throws SQLException {
		ps.setNull(index, Types.VARCHAR);
	}


	public int size(){
		return this.queries.size();
	}

	@Override
	public String toString() {
		return "TransactionStatement{" +
				"id=" + id +
				", elapsedTime=" + elapsedTime +
				'}';
	}
}
