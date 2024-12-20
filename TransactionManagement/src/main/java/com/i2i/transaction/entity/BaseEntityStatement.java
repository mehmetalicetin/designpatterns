package com.i2i.transaction.entity;

import com.i2i.transaction.command.DatabaseCommand;

import java.sql.SQLException;

public interface BaseEntityStatement<T> {
	DatabaseCommand getDatabaseCommand(T t) throws SQLException;
}
