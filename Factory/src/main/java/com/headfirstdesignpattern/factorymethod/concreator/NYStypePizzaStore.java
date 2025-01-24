package com.headfirstdesignpattern.factorymethod.concreator;

import com.headfirstdesignpattern.factorymethod.product.NYStyleCheesePizza;
import com.headfirstdesignpattern.factorymethod.product.NYStyleClamPizza;
import com.headfirstdesignpattern.simplefactorymethod.SPizza;

public class NYStypePizzaStore extends PizzaStore{
    protected SPizza createPizza(String type) {
        if(type.equals("cheese"))
            return new NYStyleCheesePizza();
        else if(type.equals("clam"))
            return new NYStyleClamPizza();
        return null;
    }
}
