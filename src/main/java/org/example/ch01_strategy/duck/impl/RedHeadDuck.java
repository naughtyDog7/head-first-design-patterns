package org.example.ch01_strategy.duck.impl;

import org.example.ch01_strategy.duck.Duck;

import static org.example.ch01_strategy.behaviour.Flyable.flyWithWings;


public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyImpl(flyWithWings());
    }
}
