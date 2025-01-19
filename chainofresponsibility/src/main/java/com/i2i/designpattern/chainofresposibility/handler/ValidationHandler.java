package com.i2i.designpattern.chainofresposibility.handler;

import com.i2i.designpattern.chainofresposibility.model.Request;

public class ValidationHandler extends RequestHandler {
	@Override
	public void handleRequest(Request request) {
		if (request.isValidData()) {
			System.out.println("Valid data");
			super.handleRequest(request);
		} else {
			throw new RuntimeException("Invalid data");
		}
	}
}
