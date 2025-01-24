package com.i2i.designpattern.chainofresposibility;

import com.i2i.designpattern.chainofresposibility.model.Request;
import com.i2i.designpattern.chainofresposibility.service.RequestProcessService;

public class Demo {
	public static void main(String[] args) {
		RequestProcessService requestProcessService = new RequestProcessService();
		requestProcessService.processRequest(getRequest());
	}

	private static Request getRequest() {
		return new Request(true, true ,true);
	}
}
