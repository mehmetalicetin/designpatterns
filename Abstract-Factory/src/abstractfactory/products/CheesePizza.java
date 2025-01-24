package abstractfactory.products;

import abstractfactory.factory.PizzaStoreIngredients;

public class CheesePizza implements Pizza{
    private final PizzaStoreIngredients pizzaStoreIngredients;
    public CheesePizza(PizzaStoreIngredients pizzaStoreIngredients) {
        this.pizzaStoreIngredients = pizzaStoreIngredients;
    }

    @Override
    public void prepare() {
        pizzaStoreIngredients.createCheese();
        pizzaStoreIngredients.createDough();
        pizzaStoreIngredients.createClam();
    }
}
