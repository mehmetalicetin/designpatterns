package com.i2i.fcbs.process.strategy;

public class LowerCaseProcessing implements ProcessingStrategy {
	@Override
	public void process(String data) {
		System.out.println("Processing data to lower Case : " + data.toLowerCase());
	}
}
