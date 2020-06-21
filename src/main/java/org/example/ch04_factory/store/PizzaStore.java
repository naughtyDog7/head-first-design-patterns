package org.example.ch04_factory.store;

import org.example.ch04_factory.pizza.Pizza;
import org.example.ch04_factory.pizza.factory.PizzaFactory;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = this.getFactory().forType(type)
                .orElseThrow();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract PizzaFactory getFactory();
}
