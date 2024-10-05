package ch01.product.paymentmethod;

public class BPaymentMethod implements PaymentMethod {
	private BPaymentMethod(){}

	public static BPaymentMethod getInstance(){
		return new BPaymentMethod();
	}
}
