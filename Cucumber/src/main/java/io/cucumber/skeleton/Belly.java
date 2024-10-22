package io.cucumber.skeleton;

public class Belly {
	int cukes;
	boolean isFull;

	public void eat(int cukes) {
		this.cukes = cukes;
	}

	public void sleep(int hours) {
		if (cukes >= 42 && hours >= 1) {
			isFull = true;
		}
	}
}
