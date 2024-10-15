package composite;

public class Product implements CartComponent {
	 String name;
	 Double price;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public double discountPrice() {
		return 0.0d;
	}
}
