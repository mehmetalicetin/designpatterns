package composite;

public class Main {
	public static void main(String[] args) {
		Product elma = new Product();
		elma.name = "apple";
		elma.price = 5.0;

		Product armut = new Product();
		armut.name = "pear";
		armut.price = 2.0;

		Product elma2 = new Product();
		elma2.name = "apple";
		elma2.price = 5.0;

		Product elma3 = new Product();
		elma3.name = "apple";
		elma3.price = 5.0;

		Cart cart = new Cart("cart-1");
		cart.add(elma);
		cart.add(elma2);
		cart.add(armut);
		cart.add(elma3);


		Cart cart2 = new Cart("cart-2");
		cart2.add(elma);
		cart2.add(elma2);
		cart2.add(armut);
		cart2.add(elma3);
		cart2.add(cart);




		System.out.println("Sum: " + CostCalculator.calculate(cart));
		System.out.println("Sum: " + CostCalculator.calculate(cart2));
	}
}
