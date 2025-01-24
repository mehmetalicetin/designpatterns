package com.i2i.designpattern.chainofresposibility.service;

import com.i2i.designpattern.chainofresposibility.handler.AuthenticationHandler;
import com.i2i.designpattern.chainofresposibility.handler.AuthorizationHandler;
import com.i2i.designpattern.chainofresposibility.handler.RequestHandler;
import com.i2i.designpattern.chainofresposibility.handler.ValidationHandler;
import com.i2i.designpattern.chainofresposibility.model.Request;

public class RequestProcessService {
	public void processRequest(Request request) {
		RequestHandler authenticationHandler = new AuthenticationHandler();
		RequestHandler authorizationHandler = new AuthorizationHandler();
		RequestHandler validationHandler = new ValidationHandler();

		authenticationHandler.setNextHandler(authorizationHandler)
				.setNextHandler(validationHandler);

		authenticationHandler.handleRequest(request);
		System.out.println("Request processed.");
	}
}
