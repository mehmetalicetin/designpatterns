import abstractfactory.factory.NYPizzaStoreIngredients;
import abstractfactory.concreator.ChicagoStylePizzaStore;
import abstractfactory.concreator.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new ChicagoStylePizzaStore(new NYPizzaStoreIngredients());
        pizzaStore.order("cheese");
    }
}