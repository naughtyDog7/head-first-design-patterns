package org.example.ch04_factory.pizza.factory;

import org.example.ch04_factory.pizza.simple.CheesePizza;
import org.example.ch04_factory.pizza.simple.GreekPizza;
import org.example.ch04_factory.pizza.simple.PepperoniPizza;
import org.example.ch04_factory.pizza.Pizza;

import java.util.Optional;

public class SimplePizzaFactory implements PizzaFactory {
    private SimplePizzaFactory() {
    }

    public Optional<Pizza> forType(String type) {
        Pizza pizza = null;
        switch (type.toLowerCase()) {
            case "greek":
                pizza = new GreekPizza();
                break;
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
        }
        return Optional.ofNullable(pizza);
    }



    private static class SingletonHolder {
        public static final SimplePizzaFactory singleton = new SimplePizzaFactory();
    }

    public static PizzaFactory getInstance() {
        return SingletonHolder.singleton;
    }
}
