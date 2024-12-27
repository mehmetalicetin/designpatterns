package com.i2i.transaction.entity.billrun;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.command.InsertCommand;
import com.i2i.transaction.entity.BaseEntityStatement;
import com.i2i.transaction.manager.TransactionContext;
import com.i2i.transaction.query.Query;
import com.i2i.transaction.query.TransactionStatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BillRunInsertStatement implements BaseEntityStatement<List<BillRunEntity>> {

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
	public DatabaseCommand getDatabaseCommand(List<BillRunEntity> billRunEntities) throws SQLException {
		PreparedStatement preparedStatement = transactionContext.getConnection().prepareStatement(INSERT_BILL_RUN);
		TransactionStatement transactionStatement = TransactionStatement.create(preparedStatement);
		for (BillRunEntity billRun : billRunEntities) {
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
			transactionStatement.addBatch(getQuery(fields));
		}
		return InsertCommand.create(transactionStatement);
	}

	private Query getQuery(Object[] fields) {
		 return Query.create("INSERT_BILL_RUN", BillRunInsertStatement.INSERT_BILL_RUN, fields);
	}

}
