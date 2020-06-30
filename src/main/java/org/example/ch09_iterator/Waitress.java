package org.example.ch09_iterator;

import org.example.ch09_iterator.menu.MenuComponent;

public class Waitress {
    private final MenuComponent menus;

    public Waitress(MenuComponent menus) {
        this.menus = menus;
    }

    public void printMenu() {
        menus.forEach(MenuComponent::print);
    }

    public void printVegetarianMenu() {
        System.out.println("\nVEGETARIAN MENU\n----");
        menus.forEach(menuComponent -> {
            if (menuComponent.isVegetarian()) {
                menuComponent.print();
            }
        });
    }
}
