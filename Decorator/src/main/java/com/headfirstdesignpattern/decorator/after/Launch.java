package com.headfirstdesignpattern.decorator.after;

import java.math.BigDecimal;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
public class Launch {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage.setSize("large");
        System.out.println("Desc:"+beverage.getDescription()+ "- Cost:$"+beverage.cost());
        beverage = new Milk(beverage);
        System.out.println("Desc:"+beverage.getDescription()+ "- Cost:$"+beverage.cost());
        beverage = new Soy(beverage);
        System.out.println("Desc:"+beverage.getDescription()+ "- Cost:$"+beverage.cost());
    }
}
