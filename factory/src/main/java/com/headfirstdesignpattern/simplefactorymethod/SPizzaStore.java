package com.headfirstdesignpattern.simplefactorymethod;

public class SPizzaStore {

    /*What's wrong with this code ???*/
    public SPizza orderPizza(String type){
        SPizza pizza = null;
        if(type.equals("chesee")){
            pizza = new SCheesePizza();
        } else if(type.equals("greek")){
            pizza = new SGreekPizza();
        } else if(type.equals("pepperoni")){
            pizza = new SPepperoniPizza();
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /*if we want to add new types of pizza this code must be modified so This code is NOT closed for modification.*/
    /*
    * else if (type.equals(“clam") { pizza = new ClamPizza();}
    * else if (type.equals(“veggie") { pizza = new VeggiePizza();}
    * */


    //Which block must be separate and which one must be encapsulated.

 /* This is what varies.
    if(type.equals("chesee")){
        pizza = new CheesePizza();
    } else if(type.equals("greek")){
        pizza = new GreekPizza();
    } else if(type.equals("pepperoni")){
        pizza = new PepperoniPizza();
    }*/



/*  This is what expect to same
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();*/


    /*Clearly, dealing with which concrete class is instantiated is really messing up our orderPizza() method
      and preventing it from being closed for modification.
      But now that we know what is varying and what isn’t, it’s probably time to encapsulate it.*/

      //go to SimplePizzaFactory

    private final SimplePizzaFactory factory;

    public SPizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.factory = simplePizzaFactory;
    }

    public SPizza neworderPizza(String type){
        SPizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /*Notice that we’ve replaced the new the operator with a create method on factory object.
    * No more concrete instantiations here!*/
}
