package com.i2i.transaction.entity.billrun;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.command.InsertCommand;
import com.i2i.transaction.entity.BaseEntityStatement;
import com.i2i.transaction.manager.TransactionContext;
import com.i2i.transaction.query.Query;
import com.i2i.transaction.query.TransactionStatement;

import java.sql.SQLException;


public class BillRunInsertStatement implements BaseEntityStatement {

	private final TransactionContext transactionContext;

	private static final String INSERT_BILL_RUN = "INSERT INTO BILL_RUN(BILLRUN_ID, BILL_ACCT_ID, UNAME, SDATE, APPLY_OCC, INV_TYPE, STATUS, INV_DATE, DUE_DATE, CDATE) "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?,?,?,?)";

	private BillRunInsertStatement(TransactionContext transactionContext) {
		this.transactionContext = transactionContext;
	}

	public static BillRunInsertStatement create(TransactionContext transactionContext) {
		return new BillRunInsertStatement(transactionContext);
	}

	@Override
	public DatabaseCommand getDatabaseCommand(BillRunEntity billRun) throws SQLException {
		int index = -1;
		Object[] fields= new Object[10];
		fields[++index] = billRun.getBillRunId();
		fields[++index] = billRun.getBillAcctId();
		fields[++index] = billRun.getLoggedInUserName();
		fields[++index] = billRun.getSDate();
		fields[++index] = billRun.getApplyOcc();
		fields[++index] = billRun.getInvType();
		fields[++index] = billRun.getStatus();
		fields[++index] = billRun.getInvDate();
		fields[++index] = billRun.getDueDate();
		fields[++index] = billRun.getCDate();
		TransactionStatement transactionStatement = getTransactionStatement(transactionContext, fields);
		return InsertCommand.create(transactionStatement);
	}

	private TransactionStatement getTransactionStatement(TransactionContext context, Object[] fields) throws SQLException {
		Query query = Query.create(BillRunInsertStatement.INSERT_BILL_RUN, fields);
		return TransactionStatement.create(query, context.getConnection());
	}

}
