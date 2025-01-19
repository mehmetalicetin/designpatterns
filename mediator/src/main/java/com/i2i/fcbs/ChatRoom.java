package com.i2i.fcbs;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Mediator{
	private List<User> users = new ArrayList<>();

	public void registerUser(User user) {
		users.add(user);
		user.setMediator(this);
	}


	@Override
	public void notify(User sender, String message) {
		sender.receive(message);
	}
}
