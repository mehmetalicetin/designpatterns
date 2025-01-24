package ch01.factory.hotela;

import ch01.factory.HotelFactory;
import ch01.product.paymentmethod.APaymentMethod;
import ch01.product.paymentmethod.PaymentMethod;
import ch01.product.room.ARoom;
import ch01.product.room.Room;

public class AHotelFactory implements HotelFactory {
	@Override
	public Room createRoom() {
		return ARoom.getInstance();
	}

	@Override
	public PaymentMethod createPaymentMethod() {
		return APaymentMethod.getInstance();
	}
}
