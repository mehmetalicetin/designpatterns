package com.i2i.transaction.command;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultProcessor {
	void process(ResultSet resultSet) throws SQLException;
}
