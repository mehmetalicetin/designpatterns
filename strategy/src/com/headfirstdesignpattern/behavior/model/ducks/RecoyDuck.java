package com.headfirstdesignpattern.behavior.model.ducks;

import com.headfirstdesignpattern.behavior.encapsulate.FlyBehavior;
import com.headfirstdesignpattern.behavior.encapsulate.FlyWithNoWay;
import com.headfirstdesignpattern.behavior.encapsulate.MuteQuack;
import com.headfirstdesignpattern.behavior.encapsulate.QuackBehavior;

public class RecoyDuck extends Duck {

    public RecoyDuck() {
        flyBehavior = new FlyWithNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("RecoyDuck");
    }
}
