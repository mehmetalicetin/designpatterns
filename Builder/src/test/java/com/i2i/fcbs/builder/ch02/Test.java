package com.i2i.fcbs.builder.ch02;

import com.i2i.fcbs.domain.Computer;

public class Test {
	public static void main(String[] args) {
		ComputerBuilderI builder = new ComputerBuilder();
		Computer computer = builder.buildComputer();
	}
}
