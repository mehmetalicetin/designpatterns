package com.i2i.designpattern.chainofresposibility.handler;

import com.i2i.designpattern.chainofresposibility.model.Request;

public class AuthorizationHandler extends RequestHandler {
	@Override
	public void handleRequest(Request request) {
		if (request.isAuthorized()){
			System.out.println("Authorized");
			super.handleRequest(request);
		} else {
			System.out.println("Unauthorized");
			throw new RuntimeException("Unauthorized");
		}
	}
}
