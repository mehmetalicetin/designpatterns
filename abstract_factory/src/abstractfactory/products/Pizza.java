package abstractfactory.products;

public interface Pizza {
    void prepare();

    default void bake(){}

    default void cut(){}

    default void box(){}
}
