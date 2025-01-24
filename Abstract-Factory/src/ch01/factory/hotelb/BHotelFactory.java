package ch01.factory.hotelb;

import ch01.factory.HotelFactory;
import ch01.product.paymentmethod.BPaymentMethod;
import ch01.product.paymentmethod.PaymentMethod;
import ch01.product.room.BRoom;
import ch01.product.room.Room;

public class BHotelFactory implements HotelFactory {
	@Override
	public Room createRoom() {
		return BRoom.getInstance();
	}

	@Override
	public PaymentMethod createPaymentMethod() {
		return BPaymentMethod.getInstance();
	}
}
