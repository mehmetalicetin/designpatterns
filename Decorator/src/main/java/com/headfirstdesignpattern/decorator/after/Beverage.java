package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public abstract class Beverage {
    public final String SMALL = "SMALL";
    public final String MEDIUM = "MEDIUM";
    public final String LARGE = "LARGE";
    private String description = "Unknown Beverage";
    private String size;

    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
