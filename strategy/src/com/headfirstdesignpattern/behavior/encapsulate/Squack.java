package com.headfirstdesignpattern.behavior.encapsulate;

public class Squack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squack");
    }
}
