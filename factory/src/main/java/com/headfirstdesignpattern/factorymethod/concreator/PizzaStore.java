package com.headfirstdesignpattern.factorymethod.concreator;

import com.headfirstdesignpattern.simplefactorymethod.SPizza;

public abstract class PizzaStore {
    public SPizza order(String type) {
        SPizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract SPizza createPizza(String type);
}
