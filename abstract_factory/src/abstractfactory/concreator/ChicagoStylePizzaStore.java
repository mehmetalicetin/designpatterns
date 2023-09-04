package abstractfactory.concreator;

import abstractfactory.factory.PizzaStoreIngredients;
import abstractfactory.products.CheesePizza;
import abstractfactory.products.DoughPizza;
import abstractfactory.products.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore {
    public ChicagoStylePizzaStore(PizzaStoreIngredients pizzaStoreIngredients) {
        super(pizzaStoreIngredients);
    }

    protected Pizza createPizza(String type) {
        if(type.equals("cheese"))
            return new CheesePizza(pizzaStoreIngredients);
        else if(type.equals("dough"))
            return new DoughPizza(pizzaStoreIngredients);
        return null;
    }
}
