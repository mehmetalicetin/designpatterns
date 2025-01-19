package com.i2i.fcbs;

public class Demo {
	public static void main(String[] args) {
		ChatRoom chatRoom = new ChatRoom();

		User user1 = new User("Ahmet");
		User user2 = new User("Ayşe");
		User user3 = new User("Mehmet");

		chatRoom.registerUser(user1);
		chatRoom.registerUser(user2);
		chatRoom.registerUser(user3);

		user1.send("Merhaba arkadaşlar!");
		user2.send("Merhaba Ahmet!");
	}
}
