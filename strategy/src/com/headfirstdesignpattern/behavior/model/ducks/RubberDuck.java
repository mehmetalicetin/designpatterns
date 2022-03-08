package com.headfirstdesignpattern.behavior.model.ducks;

import com.headfirstdesignpattern.behavior.encapsulate.FlyWithWings;
import com.headfirstdesignpattern.behavior.encapsulate.Squack;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squack();
    }

    @Override
    void display() {
        System.out.println("RubberQuack");
    }
}
