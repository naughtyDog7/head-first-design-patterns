package org.example.ch12_compound.simuduck.duck.factory;

import org.example.ch12_compound.simuduck.behaviour.Quackable;
import org.example.ch12_compound.simuduck.duck.DuckCall;
import org.example.ch12_compound.simuduck.duck.MallardDuck;
import org.example.ch12_compound.simuduck.duck.RedheadDuck;
import org.example.ch12_compound.simuduck.duck.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable mallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable redheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable duckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable rubberDuck() {
        return new RubberDuck();
    }
}
