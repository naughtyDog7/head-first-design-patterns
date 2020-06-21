package org.example.ch04_factory;

import lombok.extern.slf4j.Slf4j;
import org.example.ch04_factory.pizza.factory.PizzaFactory;
import org.example.ch04_factory.pizza.factory.SimplePizzaFactory;
import org.example.ch04_factory.store.NYPizzaStore;
import org.example.ch04_factory.store.PizzaStore;


@Slf4j
public class Main {
    public static void main(String[] args) {
        PizzaStore store1 = new PizzaStore() {
            @Override
            protected PizzaFactory getFactory() {
                return SimplePizzaFactory.getInstance();
            }
        };
        System.out.println(store1.orderPizza("Greek").getClass().getName());

        NYPizzaStore store2 = new NYPizzaStore();
        System.out.println(store2.orderPizza("Greek").getClass().getName());
    }
}
