package com.i2i.fcbs.builder.ch03;

import com.i2i.fcbs.domain.CPU;
import com.i2i.fcbs.domain.Computer;
import com.i2i.fcbs.domain.Display;
import com.i2i.fcbs.domain.Ram;

public interface ComputerBuilderI {
	ComputerBuilderI buildRam();
	ComputerBuilderI buildCpu();
	ComputerBuilderI buildDisplay();
	Computer buildComputer();
}
