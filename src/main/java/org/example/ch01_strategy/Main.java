package org.example.ch01_strategy;

import lombok.extern.slf4j.Slf4j;
import org.example.ch01_strategy.duck.Duck;
import org.example.ch01_strategy.duck.impl.RedHeadDuck;
import org.example.ch01_strategy.duck.impl.RubberDuck;


@Slf4j
public class Main {
    public static void main(String[] args) {
        Duck duck = new RedHeadDuck();
        duck.tryFly();
        duck.swim();
        duck.display();
        Duck rubberDuck = new RubberDuck();
        rubberDuck.tryFly();
        rubberDuck.swim();
        rubberDuck.display();
    }
}
