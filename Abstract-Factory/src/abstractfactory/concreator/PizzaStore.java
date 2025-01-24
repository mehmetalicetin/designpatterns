package abstractfactory.concreator;

import abstractfactory.factory.PizzaStoreIngredients;
import abstractfactory.products.Pizza;

public abstract class PizzaStore {
    protected final PizzaStoreIngredients pizzaStoreIngredients;

    public PizzaStore(PizzaStoreIngredients pizzaStoreIngredients) {
        this.pizzaStoreIngredients = pizzaStoreIngredients;
    }

    public Pizza order(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
