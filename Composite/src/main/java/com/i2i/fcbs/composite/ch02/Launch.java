package com.i2i.fcbs.composite.ch02;

public class Launch {
	public static void main(String[] args) {
		Book book = new Book("2", 200);
		Book book1 = new Book("3", 300);
		VideoGame videoGame = new VideoGame("1", 100);
		VideoGame videoGame1 = new VideoGame("4", 400);
		VideoGame videoGame2 = new VideoGame("5", 500);
		CompositeBox compositeBox = new CompositeBox(videoGame);
		CompositeBox compositeBox2 = new CompositeBox(book, book1);
		CompositeBox compositeBox3 = new CompositeBox(compositeBox2, videoGame1, videoGame2);
		DeliveryService deliveryService = new DeliveryService();
		deliveryService.setUpOrder(compositeBox, compositeBox3);
		double calculatePrice = deliveryService.calculatePrice();
		System.out.println(calculatePrice);
	}
}
