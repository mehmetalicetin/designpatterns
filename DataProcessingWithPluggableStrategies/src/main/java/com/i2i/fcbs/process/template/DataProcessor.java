package com.i2i.fcbs.process.template;

import com.i2i.fcbs.process.strategy.ProcessingStrategy;

public abstract class DataProcessor {
	private final ProcessingStrategy processingStrategy;

	protected DataProcessor(ProcessingStrategy processingStrategy) {
		this.processingStrategy = processingStrategy;
	}

	public void process(){
		String data = readData();
		processingStrategy.process(data);
		saveData();
	}

	protected abstract String readData();

	public void saveData(){
		System.out.println("Saving data");
	}
}
