package org.example.ch12_compound.simuduck.behaviour;

import java.beans.PropertyChangeListener;

public class QuackCounter implements Quackable {
    private static int numOfQuacks;
    private final Quackable quackable;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void registerObserver(PropertyChangeListener observer) {
        quackable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackable.notifyObservers();
    }

    @Override
    public void quack() {
        quackable.quack();
        numOfQuacks++;
    }

    public static int getNumOfQuacks() {
        return numOfQuacks;
    }
}
