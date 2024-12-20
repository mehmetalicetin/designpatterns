package com.i2i.transaction.entity;

import com.i2i.transaction.command.DatabaseCommand;
import com.i2i.transaction.entity.billrun.BillRunEntity;

import java.sql.SQLException;

public interface BaseEntityStatement {
	DatabaseCommand getDatabaseCommand(BillRunEntity billRun) throws SQLException;
}
