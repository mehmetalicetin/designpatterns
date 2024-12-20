package com.i2i.transaction.query;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class LogQueries {
	@Getter
	private final List<Query> executedQueries = new ArrayList<>();
	@Getter
	private final List<Query> failedQueries   = new ArrayList<>();
	private       boolean     isCommitted     = false;

	public void logExecutedQuery(TransactionStatement statement) {
		executedQueries.add(statement.getQuery());
	}

	public void logFailedQuery(TransactionStatement statement) {
		failedQueries.add(statement.getQuery());
	}

	public void setCommitted(boolean committed) {
		isCommitted = committed;
	}

	public boolean isCommitted() {
		return isCommitted;
	}

	@Override
	public String toString() {
		return "TransactionDetails{" +
				"executedQueries=" + executedQueries +
				", failedQueries=" + failedQueries +
				", isCommitted=" + isCommitted +
				'}';
	}
}
