package org.example.ch09_iterator.menu.impl;


import org.example.ch09_iterator.menu.Menu;
import org.example.ch09_iterator.menu.MenuItem;

public class PancakeHouseMenu extends Menu {
//    private final List<MenuItem> menuItems;
//    private int modNumber = 0;

    public PancakeHouseMenu() {
//        menuItems = new ArrayList<>();
        super("PancakeHouseMenu", "BREAKFAST");
        addItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
//        modNumber++;
//        menuItems.add(new MenuItem(name, description, vegetarian, price));
        menuComponents.add(new MenuItem(name, description, vegetarian, price));
    }

//    public List<MenuItem> getMenuItems() {
//        return List.copyOf(menuItems);
//    }

    @Override
    public String getName() {
        return "LUNCH";
    }

//    public Iterator<MenuItem> iterator() {
//        return menuItems.iterator();
////        return new Itr();


//    private class Itr implements Iterator<MenuItem> {
//
//        private int currentPos = 0;
//        private final int expectedModNumber = modNumber;
//
//        @Override
//        public boolean hasNext() {
//            checkModNumber();
//            return currentPos < menuItems.size()
//                    && menuItems.get(currentPos) != null;
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
//            return menuItems.get(currentPos++);
//        }
//    }

}