package com.headfirstdesignpattern.decorator.before;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-21
 */
//superType
public abstract class Beverage {
    private String description;
    private boolean milk;
    private boolean soy;
    private boolean mocha;
    private boolean whip;

    /*
    * price changes condiments will force us alter existing code
    * new condiments will force us to add new methods and alter the cost method in the super class
    * what if a customer wants a double mocha?
    * we may have new beverages. For some of these beverages (ice tea), the condiments may not be appropriate, yet
Tea subclass will still inherit methods like hasWhip()?
    * */
    protected String getDescription(){
        return "Description of Beverage";
    }

    protected Double cost(){
        double price = 0.0;
        if(isMilk()) price += 10.0;
        if(isMocha()) price += 20.0;
        if(isSoy()) price += 5.0;
        if(isWhip()) price += 2.0;
        return price;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }
}
