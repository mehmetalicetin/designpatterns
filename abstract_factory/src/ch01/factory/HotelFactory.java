package ch01.factory;

import ch01.product.paymentmethod.PaymentMethod;
import ch01.product.room.Room;

public interface HotelFactory {
	Room createRoom();
	PaymentMethod createPaymentMethod();
}
