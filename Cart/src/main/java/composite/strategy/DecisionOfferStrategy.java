package composite.strategy;

import composite.CartComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DecisionOfferStrategy implements Strategy{
	public static final String APPLE = "apple";
	public static final String PEAR = "pear";
	private final List<CartComponent> cartComponents;

	private final List<Strategy> strategies = new ArrayList<>();

	public DecisionOfferStrategy(List<CartComponent> cartComponents) {
		this.cartComponents = cartComponents;
	}

	public void addStrategy(Strategy strategy) {
		strategies.add(strategy);
	}

	public void decide() {
		offer1();
		offer2();
	}

	private void offer2() {
		Optional<Double> apple = getProductPrice(APPLE);
		Optional<Double> pear = getProductPrice(PEAR);
		if (apple.isPresent() && pear.isPresent()) {
			double sum = apple.get() + pear.get();
			addStrategy(new Offer2Strategy(sum));
		}
	}

	private Optional<Double> getProductPrice(String name) {
		return cartComponents
				.stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.map(CartComponent::getPrice)
				.findFirst();
	}

	private void offer1() {
		long count = cartComponents
				.stream()
				.map(CartComponent::getName)
				.filter(e -> e.equalsIgnoreCase(APPLE))
				.count();
		if (count == 3) {
			Optional<Double> apple = getProductPrice(APPLE);
			apple.ifPresent(price -> addStrategy(new Offer1Strategy(price)));
		}
	}

	@Override
	public double discount(){
		decide();
		return strategies.stream().mapToDouble(Strategy::discount).sum();
	}
}
