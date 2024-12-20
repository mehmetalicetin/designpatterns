package com.i2i.transaction.query;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

public class Query {
	private final String   sql;
	@Getter
	private final Object[] fields;

	private Query(String sql, Object[] fields) {
		this.sql = sql;
		this.fields = fields;
	}

	public static Query create(String query, Object[] fields) {
		return new Query(query, fields);
	}

	public String getSql() {
		Objects.requireNonNull(sql, "sql is null");
		return sql;
	}

	public void addParam(int index, Object paramValue) {
		Objects.requireNonNull(paramValue, "paramValue is null");
		fields[index] = paramValue;
	}

	@Override
	public String toString() {
		return "Query{" +
				"sql='" + sql + '\'' +
				", fields=" + Arrays.toString(fields) +
				'}';
	}
}
