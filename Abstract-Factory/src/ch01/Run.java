package ch01;

import ch01.factory.HotelFactory;
import ch01.factory.hotela.AHotelFactory;

public class Run {
	public static void main(String[] args) {
		HotelFactory factory = new AHotelFactory();
		factory.createPaymentMethod();
		factory.createRoom();
	}
}
