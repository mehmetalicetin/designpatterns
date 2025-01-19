package com.i2i.fcbs;

public class User {
	private String name;
	private Mediator mediator;

	public User(String name) {
		this.name = name;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		mediator.notify(this, message);
	}

	public void receive(String message) {
		System.out.println(name + " received " + message);
	}
}
