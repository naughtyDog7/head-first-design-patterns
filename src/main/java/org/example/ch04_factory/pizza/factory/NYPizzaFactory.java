package org.example.ch04_factory.pizza.factory;

import org.example.ch04_factory.pizza.Pizza;
import org.example.ch04_factory.pizza.nystyle.NYCheesePizza;
import org.example.ch04_factory.pizza.nystyle.NYGreekPizza;
import org.example.ch04_factory.pizza.nystyle.NYPepperoniPizza;

import java.util.Optional;

public class NYPizzaFactory implements PizzaFactory {
    private NYPizzaFactory() {
    }

    @Override
    public Optional<Pizza> forType(String type) {
        Pizza pizza = null;
        switch (type.toLowerCase()) {
            case "greek":
                pizza = new NYGreekPizza();
                break;
            case "cheese":
                pizza = new NYCheesePizza();
                break;
            case "pepperoni":
                pizza = new NYPepperoniPizza();
                break;
        }
        return Optional.ofNullable(pizza);
    }



    private static class SingletonHolder {
        public static final NYPizzaFactory singleton = new NYPizzaFactory();
    }

    public static PizzaFactory getInstance() {
        return SingletonHolder.singleton;
    }
}
