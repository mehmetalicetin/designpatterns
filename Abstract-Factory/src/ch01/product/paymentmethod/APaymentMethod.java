package ch01.product.paymentmethod;

import ch01.product.room.ARoom;

public class APaymentMethod implements PaymentMethod {
	private APaymentMethod(){}

	public static APaymentMethod getInstance(){
		return new APaymentMethod();
	}
}
