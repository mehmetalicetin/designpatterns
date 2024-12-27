package com.i2i.transaction.config;

import lombok.Getter;

@Getter
public class ConfigurationProperties {
	private final String url = "jdbc:postgresql://172.30.10.136:5432/avengers_fcbs";
	private final String username = "fcbsadm";
	private final String password = "fcbsadm";

	public static ConfigurationProperties getInstance() {
		return new ConfigurationProperties();
	}
}
