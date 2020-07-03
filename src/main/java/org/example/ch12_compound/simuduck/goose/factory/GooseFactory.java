package org.example.ch12_compound.simuduck.goose.factory;

import org.example.ch12_compound.simuduck.behaviour.Quackable;
import org.example.ch12_compound.simuduck.goose.Goose;
import org.example.ch12_compound.simuduck.goose.GooseQuackable;

public class GooseFactory extends AbstractGooseFactory {
    @Override
    public Goose goose() {
        return new Goose();
    }

    @Override
    public Quackable gooseQuackable() {
        return new GooseQuackable(goose());
    }
}
