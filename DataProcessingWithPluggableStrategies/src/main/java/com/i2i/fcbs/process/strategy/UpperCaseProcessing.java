package com.i2i.fcbs.process.strategy;

public class UpperCaseProcessing implements ProcessingStrategy {
	@Override
	public void process(String data) {
		System.out.println("Processing data to uppercase: " + data.toUpperCase());
	}
}
