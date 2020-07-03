package org.example.ch12_compound.simuduck.duck.factory;

import org.example.ch12_compound.simuduck.behaviour.QuackCounter;
import org.example.ch12_compound.simuduck.behaviour.Quackable;
import org.example.ch12_compound.simuduck.duck.DuckCall;
import org.example.ch12_compound.simuduck.duck.MallardDuck;
import org.example.ch12_compound.simuduck.duck.RedheadDuck;
import org.example.ch12_compound.simuduck.duck.RubberDuck;

public class CountingDuckFactory extends DuckFactory {
    @Override
    public Quackable mallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable redheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable duckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable rubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
