package com.i2i.fcbs.process.template;

import com.i2i.fcbs.process.strategy.ProcessingStrategy;

public class CSVDataProcessor extends DataProcessor {
	public CSVDataProcessor(ProcessingStrategy processingStrategy) {
		super(processingStrategy);
	}

	@Override
	protected String readData() {
		System.out.println("Reading data from CSV file...");
		return "csv,data,example";
	}
}
