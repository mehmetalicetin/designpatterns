package com.headfirstdesignpattern;

import com.headfirstdesignpattern.factorymethod.concreator.NYStypePizzaStore;
import com.headfirstdesignpattern.factorymethod.concreator.PizzaStore;

public class Launch {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStypePizzaStore();
        pizzaStore.order("cheese");
    }
}
