package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return this.beverage.cost().add(BigDecimal.valueOf(0.10)).add(getSizePrice());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Wrapped by Milk";
    }

    public BigDecimal getSizePrice() {
        if(beverage.getSize().equalsIgnoreCase(beverage.SMALL)) return BigDecimal.valueOf(.010);
        if(beverage.getSize().equalsIgnoreCase(beverage.MEDIUM)) return BigDecimal.valueOf(.015);
        if (beverage.getSize().equalsIgnoreCase(beverage.LARGE)) return BigDecimal.valueOf(0.020);
        return BigDecimal.valueOf(0.0);
    }
}
