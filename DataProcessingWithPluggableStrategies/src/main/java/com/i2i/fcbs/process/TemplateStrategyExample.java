package com.i2i.fcbs.process;

import com.i2i.fcbs.process.strategy.UpperCaseProcessing;
import com.i2i.fcbs.process.template.CSVDataProcessor;
import com.i2i.fcbs.process.template.DataProcessor;
import com.i2i.fcbs.process.template.JSONDataProcessor;

public class TemplateStrategyExample {
	public static void main(String[] args) {
		//CSV Processor with upper case strategy
		DataProcessor csvDataProcessor = new CSVDataProcessor(new UpperCaseProcessing());
		csvDataProcessor.process();

		//JSON Processor with LowerCase Strategy
		DataProcessor jsonDataProcessor = new JSONDataProcessor(new UpperCaseProcessing());
		jsonDataProcessor.process();

	}
}
