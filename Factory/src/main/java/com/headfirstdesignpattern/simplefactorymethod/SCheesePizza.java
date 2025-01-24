package com.headfirstdesignpattern.simplefactorymethod;

import com.headfirstdesignpattern.abstractfactory.PizzaStoreIngredients;
import com.headfirstdesignpattern.abstractfactory.productsimpl.Pizza;

public class SCheesePizza implements Pizza {
    PizzaStoreIngredients pizzaStoreIngredients;
    public SCheesePizza(PizzaStoreIngredients pizzaStoreIngredients) {
        this.pizzaStoreIngredients = pizzaStoreIngredients;
    }

    @Override
    public void prepare() {
        pizzaStoreIngredients.createCheese();
        pizzaStoreIngredients.createDough();
        pizzaStoreIngredients.createClam();
    }
}
