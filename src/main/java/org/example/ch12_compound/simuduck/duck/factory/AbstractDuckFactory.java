package org.example.ch12_compound.simuduck.duck.factory;

import org.example.ch12_compound.simuduck.behaviour.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable mallardDuck();
    public abstract Quackable redheadDuck();
    public abstract Quackable duckCall();
    public abstract Quackable rubberDuck();
}
