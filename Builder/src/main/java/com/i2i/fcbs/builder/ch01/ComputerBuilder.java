package com.i2i.fcbs.builder.ch01;

import com.i2i.fcbs.domain.CPU;
import com.i2i.fcbs.domain.Computer;
import com.i2i.fcbs.domain.Display;
import com.i2i.fcbs.domain.Ram;

public class ComputerBuilder implements ComputerBuilderI{
	private Computer computer;

	public ComputerBuilder() {}

	@Override
	public Ram buildRam() {
		Ram ram = new Ram();
		computer.setRam(ram);
		return ram;
	}

	@Override
	public CPU buildCpu() {
		CPU cpu = new CPU();
		computer.setCpu(cpu);
		return cpu;
	}

	@Override
	public Display buildDisplay() {
		Display display = new Display();
		computer.setDisplay(display);
		return display;
	}

	@Override
	public Computer buildComputer() {
		computer = new Computer();
		buildRam();
		buildCpu();
		buildDisplay();
		return computer;
	}
}
