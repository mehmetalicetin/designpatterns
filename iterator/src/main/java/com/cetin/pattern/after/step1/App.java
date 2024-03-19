package com.cetin.pattern.after.step1;

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
