package com.i2i.fcbs.builder.ch04;

import com.i2i.fcbs.domain.CPU;
import com.i2i.fcbs.domain.Display;
import com.i2i.fcbs.domain.Mouse;
import com.i2i.fcbs.domain.Ram;

public class Computer {
	private String  name;
	private CPU     cpu;
	private Ram     ram;
	private Mouse   mouse;
	private Display display;

	private Computer() {}

	private Computer(String name, CPU cpu, Ram ram, Mouse mouse, Display display) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.mouse = mouse;
		this.display = display;
	}

	private Computer(String name, CPU cpu, Ram ram, Mouse mouse) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.mouse = mouse;
	}

	private Computer(String name, CPU cpu, Ram ram) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
	}


	private Computer(String name, CPU cpu) {
		this.name = name;
		this.cpu = cpu;
	}

	public String getName() {
		return name;
	}

	public CPU getCpu() {
		return cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public Display getDisplay() {
		return display;
	}

	public static class Builder{
		private String  name;
		private CPU     cpu;
		private Ram     ram;
		private Mouse   mouse;
		private Display display;

		public Builder(String name) {
			this.name = name;
		}
		public Builder setCpu() {
			this.cpu = new CPU();
			return this;
		}
		public Builder setRam() {
			this.ram = new Ram();
			return this;
		}
		public Builder setMouse() {
			this.mouse = new Mouse();
			return this;
		}
		public Builder setDisplay() {
			this.display = new Display();
			return this;
		}
		public Computer build() {
			return new Computer(name, cpu, ram, mouse, display);
		}
	}
}
