package org.example.ch12_compound.simuduck.duck;

import org.example.ch12_compound.simuduck.behaviour.QuackObservable;
import org.example.ch12_compound.simuduck.behaviour.Quackable;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private final List<Quackable> quackables;

    public Flock() {
        this.quackables = new ArrayList<>();
    }

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        quackables.forEach(Quackable::quack);
    }

    @Override
    public void registerObserver(PropertyChangeListener observer) {
        quackables.forEach(i -> i.registerObserver(observer));
    }

    @Override
    public void notifyObservers() {
        quackables.forEach(QuackObservable::notifyObservers);
    }
}
