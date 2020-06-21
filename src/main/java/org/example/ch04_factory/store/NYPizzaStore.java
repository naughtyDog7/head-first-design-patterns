package org.example.ch04_factory.store;

import org.example.ch04_factory.pizza.Pizza;
import org.example.ch04_factory.pizza.factory.NYPizzaFactory;
import org.example.ch04_factory.pizza.factory.PizzaFactory;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza orderPizza(String type) {
        return super.orderPizza(type);
    }

    @Override
    protected PizzaFactory getFactory() {
        return NYPizzaFactory.getInstance();
    }
}
