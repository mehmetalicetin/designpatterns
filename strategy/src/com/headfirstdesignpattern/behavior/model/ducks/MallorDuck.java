package com.headfirstdesignpattern.behavior.model.ducks;

import com.headfirstdesignpattern.behavior.encapsulate.FlyBehavior;
import com.headfirstdesignpattern.behavior.encapsulate.FlyWithWings;
import com.headfirstdesignpattern.behavior.encapsulate.Quack;
import com.headfirstdesignpattern.behavior.encapsulate.QuackBehavior;

public class MallorDuck extends Duck{

    public MallorDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("MallorDuck");
    }

}
