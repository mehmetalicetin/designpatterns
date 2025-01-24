package com.i2i.designpattern.chainofresposibility.handler;

import com.i2i.designpattern.chainofresposibility.model.Request;

public abstract class RequestHandler {
	protected RequestHandler nextHandler;

	public RequestHandler setNextHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
		return nextHandler;
	}
	public void handleRequest(Request request){
		if(nextHandler != null){
			nextHandler.handleRequest(request);
		}
	}
}
