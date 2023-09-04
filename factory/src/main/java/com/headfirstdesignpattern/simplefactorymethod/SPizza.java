package com.headfirstdesignpattern.simplefactorymethod;

public interface SPizza {
    void prepare();

    default void bake() {

    }

    default void cut() {

    }

    default void box() {

    }
}
