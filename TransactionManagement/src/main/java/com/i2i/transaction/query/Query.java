package com.i2i.transaction.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;

public class Query {
	private final String name;
	private final String   sql;
	@Getter
	private final Object[] fields;
	@Setter
	private long elapsedTime;

	private Query(String name, String sql, Object[] fields) {
		this.name = name;
		this.sql = sql;
		this.fields = fields;
	}

	public static Query create(String name, String query, Object[] fields) {
		return new Query(name, query, fields);
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
				"name='" + name + '\'' +
				", elapsedTime=" + elapsedTime + "ms" +
				'}';
	}
}
