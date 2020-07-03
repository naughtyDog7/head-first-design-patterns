package org.example.ch12_compound.simuduck.goose.factory;

import org.example.ch12_compound.simuduck.behaviour.Quackable;
import org.example.ch12_compound.simuduck.goose.Goose;

public abstract class AbstractGooseFactory {
    public abstract Goose goose();
    public abstract Quackable gooseQuackable();
}
