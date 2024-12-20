package com.headfirstdesignpattern.behavior.encapsulate;

public class FlyWithNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly With No Way");
    }
}
