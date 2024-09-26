package com.i2i.fcbs.builder.ch01;

import com.i2i.fcbs.domain.CPU;
import com.i2i.fcbs.domain.Computer;
import com.i2i.fcbs.domain.Display;
import com.i2i.fcbs.domain.Ram;

public interface ComputerBuilderI {
	Ram buildRam();
	CPU buildCpu();
	Display buildDisplay();
	Computer buildComputer();
}
