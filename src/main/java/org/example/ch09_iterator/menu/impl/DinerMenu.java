package org.example.ch09_iterator.menu.impl;


import org.example.ch09_iterator.menu.Menu;
import org.example.ch09_iterator.menu.MenuItem;

public class DinerMenu extends Menu {
//    private static final int MAX_ITEMS = 6;
//    private final MenuItem[] menuItems;
//    private int numOfItems;
//    private int modNumber;


    public DinerMenu() {
//        menuItems = new MenuItem[MAX_ITEMS];
        super("DinerMenu", "LUNCH");
        addItem("Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
//        try {
//            menuItems[numOfItems++] = new MenuItem(name, description, vegetarian, price);
//            modNumber++;
//        } catch (Exception e) {
//            System.err.println("Sorry, menu is full");
//            numOfItems--;
//        }
        menuComponents.add(new MenuItem(name, description, vegetarian, price));
    }

//    public MenuItem[] getMenuItems() {
//        return Arrays.copyOf(menuItems, menuItems.length);
//    }

//    public Iterator<MenuItem> iterator() {
//        return new Itr();
//    }

//    private class Itr implements Iterator<MenuItem> {
//
//        private int currentPos = 0;
//        private final int expectedModNumber = modNumber;
//
//        @Override
//        public boolean hasNext() {
//            checkModNumber();
//            return currentPos < menuItems.length
//                    && menuItems[currentPos] != null;
//        }
//
//        public void checkModNumber() {
//            if (modNumber != expectedModNumber) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        @Override
//        public MenuItem next() {
//            checkModNumber();
//            return menuItems[currentPos++];
//        }
//    }
}
