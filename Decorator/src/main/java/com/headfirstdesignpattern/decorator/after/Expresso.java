package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public class Expresso extends Beverage{
    @Override
    public String getDescription() {
        return "Expresso Order";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.99);
    }
}
