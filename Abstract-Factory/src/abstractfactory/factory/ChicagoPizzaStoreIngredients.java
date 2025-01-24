package abstractfactory.factory;

import abstractfactory.ingredients.cheese.Cheese;
import abstractfactory.ingredients.cheese.MarinaCheese;
import abstractfactory.ingredients.clam.Clam;
import abstractfactory.ingredients.clam.FrozenClams;
import abstractfactory.ingredients.dough.Dough;
import abstractfactory.ingredients.dough.ThickCrustDough;

public class ChicagoPizzaStoreIngredients implements PizzaStoreIngredients{
    public Dough createDough() {
        return new ThickCrustDough();
    }

    public Cheese createCheese() {
        return new MarinaCheese();
    }

    public Clam createClam() {
        return new FrozenClams();
    }
}
