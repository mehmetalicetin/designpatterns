package com.i2i.transaction.manager;

import com.i2i.transaction.command.DatabaseCommand;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
	private final TransactionContext    context;
	private final List<DatabaseCommand> commands = new ArrayList<>();

	public TransactionManager(TransactionContext context) {
		this.context = context;
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
			command.execute(context.getLogTransactions());
		}catch (SQLException e){
			command.rollback(context.getLogTransactions());
			e.printStackTrace();
		}
	}
}
