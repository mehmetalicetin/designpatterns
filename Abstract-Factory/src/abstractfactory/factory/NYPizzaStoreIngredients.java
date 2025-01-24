package abstractfactory.factory;

import abstractfactory.ingredients.cheese.MozerallaCheese;
import abstractfactory.ingredients.clam.Clam;
import abstractfactory.ingredients.clam.FreshClams;
import abstractfactory.ingredients.cheese.Cheese;
import abstractfactory.ingredients.dough.Dough;
import abstractfactory.ingredients.dough.ThinCrustDough;

public class NYPizzaStoreIngredients implements PizzaStoreIngredients{
    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Cheese createCheese() {
        return new MozerallaCheese();
    }

    public Clam createClam() {
        return new FreshClams();
    }
}
