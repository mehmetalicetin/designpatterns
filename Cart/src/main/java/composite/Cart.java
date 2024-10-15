package composite;

import composite.strategy.DecisionOfferStrategy;
import composite.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart implements CartComponent {
	public static final String APPLE = "apple";
	public static final String PEAR = "pear";
	String              name;
	List<CartComponent> cartComponents = new ArrayList<>();

	public Cart(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return cartComponents.stream().mapToDouble(CartComponent::getPrice).sum();
	}

	@Override
	public void add(CartComponent cartComponent) {
		if (Objects.isNull(cartComponent)) {
			return;
		}
		cartComponents.add(cartComponent);
	}

	@Override
	public double discountPrice() {
		Strategy strategy = new DecisionOfferStrategy(this.cartComponents);
		return strategy.discount();
	}

	private double discount() {
		return discountPrice() + cartComponents.stream().mapToDouble(CartComponent::discountPrice).sum();
	}

	@Override
	public double netPrice() {
		return getPrice() - discount();
	}
}
