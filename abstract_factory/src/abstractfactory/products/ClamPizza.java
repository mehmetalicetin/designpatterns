package abstractfactory.products;

import abstractfactory.factory.PizzaStoreIngredients;

public class ClamPizza implements Pizza{
    private final PizzaStoreIngredients pizzaStoreIngredients;
    public ClamPizza(PizzaStoreIngredients pizzaStoreIngredients) {
        this.pizzaStoreIngredients = pizzaStoreIngredients;
    }

    @Override
    public void prepare() {
        pizzaStoreIngredients.createCheese();
        pizzaStoreIngredients.createDough();
        pizzaStoreIngredients.createClam();
    }
}
