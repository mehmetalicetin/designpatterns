package com.headfirstdesignpattern.observerpattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WeatherData implements Observable {
    List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;
    private boolean changed = false;

    @Override
    public void add(Observer observer) {
        if(Objects.nonNull(observer))
            observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        if(Objects.nonNull(observer))
            observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if (changed)
            observers.forEach(observer -> observer.update(temperature, humidity, pressure));
        changed = false;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        setChanged();
        notifyObserver();
    }

    private void setChanged() {
        changed = true;
    }
}
