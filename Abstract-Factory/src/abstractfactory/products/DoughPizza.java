package abstractfactory.products;

import abstractfactory.factory.PizzaStoreIngredients;

public class DoughPizza implements Pizza{
    private final PizzaStoreIngredients pizzaStoreIngredients;
    public DoughPizza(PizzaStoreIngredients pizzaStoreIngredients) {
        this.pizzaStoreIngredients = pizzaStoreIngredients;
    }

    @Override
    public void prepare() {
        this.pizzaStoreIngredients.createCheese();
        this.pizzaStoreIngredients.createDough();
        this.pizzaStoreIngredients.createClam();
    }
}
