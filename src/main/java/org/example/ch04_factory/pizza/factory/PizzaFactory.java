package org.example.ch04_factory.pizza.factory;

import org.example.ch04_factory.pizza.Pizza;

import java.util.Optional;

public interface PizzaFactory {
    Optional<Pizza> forType(String type);
}
