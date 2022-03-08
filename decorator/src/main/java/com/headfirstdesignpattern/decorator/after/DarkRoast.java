package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public class DarkRoast extends Beverage{
    @Override
    public String getDescription() {
        return "DarkRoast Order";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0.99);
    }
}
