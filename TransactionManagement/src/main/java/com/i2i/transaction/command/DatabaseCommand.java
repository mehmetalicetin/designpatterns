package com.i2i.transaction.command;

import com.i2i.transaction.query.LogQueries;

import java.sql.SQLException;

public interface DatabaseCommand {
	void execute(LogQueries logQueries) throws SQLException;
	void rollback(LogQueries logQueries) throws SQLException;
}