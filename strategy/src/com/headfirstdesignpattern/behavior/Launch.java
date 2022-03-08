package com.headfirstdesignpattern.behavior;

import com.headfirstdesignpattern.behavior.encapsulate.FlyWithNoWay;
import com.headfirstdesignpattern.behavior.model.ducks.Duck;
import com.headfirstdesignpattern.behavior.model.ducks.MallorDuck;

public class Launch {
    public static void main(String[] args) {
        Duck mallorDuck = new MallorDuck();
        mallorDuck.performFlyBehavior();
        mallorDuck.setFlyBehavior(new FlyWithNoWay());
        mallorDuck.performFlyBehavior();
        mallorDuck.perfomQuackBehavior();
    }
}
