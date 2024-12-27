package com.i2i.transaction.manager;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.query.LogQueries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
	private final TransactionContext    context;
	private final LogQueries logQueries;
	private final List<DatabaseCommand> commands = new ArrayList<>();

	private TransactionManager(TransactionContext context) {
		this.context = context;
		this.logQueries = new LogQueries();
	}

	public static TransactionManager create(TransactionContext context) {
		return new TransactionManager(context);
	}

	public void addCommand(DatabaseCommand command) {
		commands.add(command);
	}

	public void execute() {
		try {
			for (DatabaseCommand command : commands) {
				execute(command);
			}
			context.commit();
		} catch (SQLException e) {
			try {
				context.rollback();
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
		} finally {
			try {
				context.close();
			} catch (SQLException closeEx) {
				closeEx.printStackTrace();
			}
		}
	}

	private void execute(DatabaseCommand command) throws SQLException {
		try{
			command.execute(logQueries);
		}catch (SQLException e){
			command.rollback(logQueries);
			e.printStackTrace();
		}
	}

	public LogQueries getLogQueries() {
		return logQueries;
	}
}
