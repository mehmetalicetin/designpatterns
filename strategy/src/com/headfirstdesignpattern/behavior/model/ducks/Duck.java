package com.headfirstdesignpattern.behavior.model.ducks;

import com.headfirstdesignpattern.behavior.encapsulate.FlyBehavior;
import com.headfirstdesignpattern.behavior.encapsulate.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    protected Duck() {
    }

    public void perfomQuackBehavior(){
        quackBehavior.quack();
    }

    public void performFlyBehavior(){
        flyBehavior.fly();
    }

    void swim(){
        System.out.println("ducks can swim");
    };

    abstract void display();

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
