package com.headfirstdesignpattern.behavior.encapsulate;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Mute Quack");
    }
}
