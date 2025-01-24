package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return this.beverage.cost().add(BigDecimal.valueOf(0.15));
    }

    @Override
    public String getDescription() {
        return "Wrapped by Soya";
    }
}
