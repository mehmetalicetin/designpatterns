package composite.strategy;

public class Offer1Strategy implements Strategy {
	// * Example: 3 apples in cart -> get one free

	double price;
	public Offer1Strategy(double price) {
		this.price = price;
	}
	@Override
	public double discount() {
		return price;
	}
}
