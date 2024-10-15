package composite.strategy;

public class Offer2Strategy implements Strategy {
	double price;

	public Offer2Strategy(double price) {
		this.price = price;
	}

	@Override
	public double discount() {
		return price*.03;
	}
}
