package org.example.ch09_iterator.menu.impl;

import org.example.ch09_iterator.menu.Menu;
import org.example.ch09_iterator.menu.MenuItem;

public class CafeMenu extends Menu {
//    private final Map<String, MenuItem> menuItems;

    public CafeMenu() {
//        menuItems = new HashMap<>();
        super("CafeMenu", "Dinner");
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);

    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
//        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
//        menuItems.put(menuItem.getName(), menuItem);
        menuComponents.add(new MenuItem(name, description, vegetarian, price));
    }

//    public Map<String, MenuItem> getMenuItems() {
//        return Map.copyOf(menuItems);
//    }

    @Override
    public String getName() {
        return "DINNER";
    }
}
