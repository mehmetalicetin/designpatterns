package com.i2i.fcbs.builder.ch03;

import com.i2i.fcbs.domain.CPU;
import com.i2i.fcbs.domain.Computer;
import com.i2i.fcbs.domain.Display;
import com.i2i.fcbs.domain.Ram;

public class ComputerBuilder implements ComputerBuilderI{
	Computer computer;


	public ComputerBuilder() {
		computer = new Computer();
	}

	@Override
	public ComputerBuilderI buildRam() {
		Ram ram = new Ram();
		computer.setRam(ram);
		return this;
	}

	@Override
	public ComputerBuilderI buildCpu() {
		CPU cpu = new CPU();
		computer.setCpu(cpu);
		return this;
	}

	@Override
	public ComputerBuilderI buildDisplay() {
		Display display = new Display();
		computer.setDisplay(display);
		return this;
	}

	@Override
	public Computer buildComputer() {
		return computer;
	}
}
