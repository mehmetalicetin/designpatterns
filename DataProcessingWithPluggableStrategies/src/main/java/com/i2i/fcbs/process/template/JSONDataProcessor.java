package com.i2i.fcbs.process.template;

import com.i2i.fcbs.process.strategy.ProcessingStrategy;

public class JSONDataProcessor extends DataProcessor {
	public JSONDataProcessor(ProcessingStrategy processingStrategy) {
		super(processingStrategy);
	}

	@Override
	protected String readData() {
		System.out.println("Reading data from JSON file...");
		return "{ \"key\": \"value\" }";
	}
}
