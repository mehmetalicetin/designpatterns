package com.headfirstdesignpattern.observerpattern;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObserver();
}
