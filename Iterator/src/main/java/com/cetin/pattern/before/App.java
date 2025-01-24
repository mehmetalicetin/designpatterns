package com.cetin.pattern.before;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
