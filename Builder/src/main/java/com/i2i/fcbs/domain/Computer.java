package com.i2i.fcbs.domain;

public class Computer {
	private String name;
	private CPU cpu;
	private Ram ram;
	private Mouse mouse;
	private Display display;

	public Computer() {}

	public Computer(String name, CPU cpu, Ram ram, Mouse mouse, Display display) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.mouse = mouse;
		this.display = display;
	}

	public Computer(String name, CPU cpu, Ram ram, Mouse mouse) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.mouse = mouse;
	}

	public Computer(String name, CPU cpu, Ram ram) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
	}


	public Computer(String name, CPU cpu) {
		this.name = name;
		this.cpu = cpu;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
}
