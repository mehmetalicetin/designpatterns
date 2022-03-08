package com.headfirstdesignpattern.behavior.model.ducks;

import com.headfirstdesignpattern.behavior.encapsulate.FlyWithWings;
import com.headfirstdesignpattern.behavior.encapsulate.Squack;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squack();
    }

    @Override
    void display() {
        System.out.println("Redheadduck");
    }
}
