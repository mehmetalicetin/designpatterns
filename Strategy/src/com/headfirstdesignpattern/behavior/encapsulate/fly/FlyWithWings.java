package com.headfirstdesignpattern.behavior.encapsulate;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly With Wings");
    }
}
