package com.i2i.transaction.run;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.entity.billrun.BillRunEntity;
import com.i2i.transaction.entity.billrun.BillRunInsertStatement;
import com.i2i.transaction.entity.billrun.BillRunSelectStatement;
import com.i2i.transaction.manager.TransactionContext;
import com.i2i.transaction.manager.TransactionManager;
import com.i2i.transaction.query.LogQueries;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Launch {
	private static List<BillRunEntity> billRunEntities = new ArrayList<>();

	public static void main(String[] args) {
		try {
			TransactionContext context = new TransactionContext();
			TransactionManager manager = new TransactionManager(context);
			addCommands(context, manager);
			manager.execute();
			LogQueries logQueries = manager.getLogQueries();
			logQueries.getExecutedQueries().forEach(System.out::println);
			logQueries.getFailedQueries().forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//BILLRUN_ID, BILL_ACCT_ID, UNAME, SDATE, APPLY_OCC, INV_TYPE, STATUS, INV_DATE, DUE_DATE, CDATE
	private static void addCommands(TransactionContext context, TransactionManager manager) throws SQLException {
		DatabaseCommand billRunInsertCommand = getBillRunInsertCommand(context);
		manager.addCommand(billRunInsertCommand);
		DatabaseCommand billRunSelect = getBillRunSelectCommand(context);
		manager.addCommand(billRunSelect);
	}

	private static DatabaseCommand getBillRunSelectCommand(TransactionContext context) throws SQLException {
		return BillRunSelectStatement.create(context).getDatabaseCommand(billRunEntities);
	}

	private static DatabaseCommand getBillRunInsertCommand(TransactionContext context) throws SQLException {
		BillRunEntity billRun = BillRunEntity.builder()
				.billRunId(-1L)
				.billAcctId(1213963L)
				.loggedInUserName("Deneme-Cetin")
				.sDate(Timestamp.from(Instant.now()))
				.applyOcc("X")
				.invType("IN")
				.status("D")
				.invDate(Timestamp.from(Instant.now()))
				.dueDate(Timestamp.from(Instant.now()))
				.cDate(Timestamp.from(Instant.now()))
				.build();
		return BillRunInsertStatement.create(context).getDatabaseCommand(billRun);
	}
}
