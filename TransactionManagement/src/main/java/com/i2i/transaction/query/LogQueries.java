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
		System.out.println(String.format("Log succeed: Transaction_Id:%d  Size:%d", statement.getId(), statement.size()));
		for (Query query : statement.getQueries()) {
			query.setElapsedTime(statement.getElapsedTime());
			executedQueries.add(query);
		}
	}

	public void logFailedQuery(TransactionStatement statement) {
		System.out.println(String.format("Log failed: Transaction_Id:%d  Size:%d", statement.getId(), statement.size()));
		for (Query query : statement.getQueries()) {
			query.setElapsedTime(statement.getElapsedTime());
			failedQueries.addAll(statement.getQueries());
		}
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
