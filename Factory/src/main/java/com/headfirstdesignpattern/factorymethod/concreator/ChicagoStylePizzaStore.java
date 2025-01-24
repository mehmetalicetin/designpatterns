package com.headfirstdesignpattern.factorymethod.concreator;

import com.headfirstdesignpattern.factorymethod.product.ChicagoStyleCheesePizza;
import com.headfirstdesignpattern.factorymethod.product.ChicagoStyleClamPizza;
import com.headfirstdesignpattern.simplefactorymethod.SPizza;

public class ChicagoStylePizzaStore extends PizzaStore{
    protected SPizza createPizza(String type) {
        if(type.equals("cheese"))
            return new ChicagoStyleCheesePizza();
        else if(type.equals("clam"))
            return new ChicagoStyleClamPizza();
        return null;
    }
}
