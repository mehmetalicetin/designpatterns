package com.i2i.transaction.query;

import lombok.Getter;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Objects;

@Getter
public final class TransactionStatement {
	private final Query             query;
	private final PreparedStatement statement;

	private TransactionStatement(Query query, Connection connection) throws SQLException {
		this.query = query;
		Objects.requireNonNull(query, "query cannot be null");
		this.statement = connection.prepareStatement(query.getSql());
		arrangeStatements();
	}

	public static TransactionStatement create(Query query, Connection connection) throws SQLException {
		return new TransactionStatement(query, connection);
	}

	private void arrangeStatements() throws SQLException {
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
}
