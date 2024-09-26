package com.i2i.fcbs.builder.ch05;

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

	private Computer() {
	}

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

	public static class Builder {
		private final String  name;
		private       boolean hasCPU;
		private       boolean hasRam;
		private       boolean hasMouse;
		private       boolean hasDisplay;

		public Builder(String name) {
			this.name = name;
		}

		public Builder setCpu() {
			this.hasCPU = true;
			return this;
		}

		public Builder setRam() {
			this.hasRam = true;
			return this;
		}

		public Builder setMouse() {
			this.hasMouse = true;
			return this;
		}

		public Builder setDisplay() {
			this.hasDisplay = true;
			return this;
		}

		public Computer build() {
			Computer computer = new Computer();
			if (hasCPU) {
				computer.cpu = new CPU();
			}
			if (hasDisplay) {
				computer.ram = new Ram();
			}
			if (hasRam) {
				computer.ram = new Ram();
			}
			if (hasMouse) {
				computer.mouse = new Mouse();
			}
			return computer;
		}
	}
}
