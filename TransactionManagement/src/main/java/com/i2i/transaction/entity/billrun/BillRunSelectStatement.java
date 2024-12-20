package com.i2i.transaction.entity.billrun;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.command.InsertCommand;
import com.i2i.transaction.command.SelectCommand;
import com.i2i.transaction.entity.BaseEntityStatement;
import com.i2i.transaction.manager.TransactionContext;
import com.i2i.transaction.query.Query;
import com.i2i.transaction.query.TransactionStatement;

import java.sql.SQLException;
import java.util.List;

public class BillRunSelectStatement implements BaseEntityStatement<List<BillRunEntity>> {

	private final TransactionContext transactionContext;

	private static final String SELECT_BILL_RUN = "SELECT * FROM BILL_RUN LIMIT 10";

	private BillRunSelectStatement(TransactionContext transactionContext) {
		this.transactionContext = transactionContext;
	}

	public static BillRunSelectStatement create(TransactionContext transactionContext) {
		return new BillRunSelectStatement(transactionContext);
	}

	@Override
	public DatabaseCommand getDatabaseCommand(List<BillRunEntity> billRunEntities) throws SQLException {
		TransactionStatement transactionStatement = getTransactionStatement(transactionContext);
		return new SelectCommand(transactionStatement, resultSet -> {
			while (resultSet.next()) {
				long id = resultSet.getLong("billrun_id");
				long billAcctId = resultSet.getLong("bill_acct_id");
				String uname = resultSet.getString("uname");
				BillRunEntity billRun = BillRunEntity.builder()
						.billRunId(id)
						.billAcctId(billAcctId)
						.loggedInUserName(uname)
						.build();
				billRunEntities.add(billRun);
			}
		});
	}

	private TransactionStatement getTransactionStatement(TransactionContext context, Object... fields) throws SQLException {
		Query query = Query.create("SELECT_BILL_RUN", BillRunSelectStatement.SELECT_BILL_RUN, fields);
		return TransactionStatement.create(query, context.getConnection());
	}
}
