package com.i2i.designpattern.chainofresposibility.model;

public class Request {
	private boolean authenticated;
	private boolean authorized;
	private boolean validData;

	public Request(boolean authenticated, boolean authorized, boolean validData) {
		this.authenticated = authenticated;
		this.authorized = authorized;
		this.validData = validData;
	}

	public boolean isAuthenticated() { return authenticated; }
	public boolean isAuthorized() { return authorized; }
	public boolean isValidData() { return validData; }
}
