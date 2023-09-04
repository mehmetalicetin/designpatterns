package com.headfirstdesignpattern.simplefactorymethod;

public class SimplePizzaFactory{
    //Encapsulating Object Creation

    /*First we pull the object creation code out of the orderPizza Method*/

    public SPizza createPizza(String type){
        SPizza pizza = null;
        if(type.equals("chesee")){
            pizza = new SCheesePizza();
        } else if(type.equals("greek")){
            pizza = new SGreekPizza();
        } else if(type.equals("pepperoni")){
            pizza = new SPepperoniPizza();
        }
        return pizza;
    }

    /*Then we place that code in an object that is only going to worry about how to create pizzas.
      If any other object needs a pizza created, this is the object to come to.*/



   //Here’s our new class, the SimplePizzaFactory. It has one job in life: creating pizzas for its clients.
}
