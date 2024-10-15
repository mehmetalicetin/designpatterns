package composite;

public interface CartComponent {
	String getName();
	Double getPrice();
	double discountPrice();

	default double netPrice(){
		throw new UnsupportedOperationException("Not supported yet.");
	}

	default void add(CartComponent cartComponent){
		throw new UnsupportedOperationException("Not supported yet.");
	}

	default void remove(CartComponent cartComponent){
		throw new UnsupportedOperationException("Not supported yet.");
	}


}
