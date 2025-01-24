package com.i2i.designpattern.chainofresposibility.handler;

import com.i2i.designpattern.chainofresposibility.model.Request;

public class AuthenticationHandler extends RequestHandler {
	@Override
	public void handleRequest(Request request) {
		if (request.isAuthenticated()){
			System.out.println("Authenticated");
			super.handleRequest(request);
		} else {
			System.out.println("Not Authenticated");
			throw new RuntimeException("Not Authenticated");
		}
	}
}
