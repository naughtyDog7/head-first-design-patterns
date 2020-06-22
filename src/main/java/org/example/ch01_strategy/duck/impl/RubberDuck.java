package org.example.ch01_strategy.duck.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.ch01_strategy.duck.Duck;

import static org.example.ch01_strategy.behaviour.Flyable.flyNoWings;

@EqualsAndHashCode(callSuper = true)
@Data
public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyImpl(flyNoWings());
    }
}
