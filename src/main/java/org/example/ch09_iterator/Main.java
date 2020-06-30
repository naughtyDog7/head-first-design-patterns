package org.example.ch09_iterator;

import lombok.extern.slf4j.Slf4j;
import org.example.ch09_iterator.menu.Menu;
import org.example.ch09_iterator.menu.MenuItem;
import org.example.ch09_iterator.menu.impl.CafeMenu;
import org.example.ch09_iterator.menu.impl.DinerMenu;
import org.example.ch09_iterator.menu.impl.PancakeHouseMenu;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        Menu cafeMenu = new CafeMenu();
        Menu dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89));

        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));

        Menu muzap = new Menu("TEST MENU" , "TEST");
        dessertMenu.add(muzap);
        muzap.add(new MenuItem("TEST ITEM", "TEST", true, 2.4));

        Waitress waitress = new Waitress(allMenus);
//        waitress.printMenu();

        waitress.printVegetarianMenu();
    }

}
