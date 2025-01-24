package abstractfactory.factory;

import abstractfactory.ingredients.clam.Clam;
import abstractfactory.ingredients.cheese.Cheese;
import abstractfactory.ingredients.dough.Dough;

public interface PizzaStoreIngredients {
    Dough createDough();
    Cheese createCheese();
    Clam createClam();
}
