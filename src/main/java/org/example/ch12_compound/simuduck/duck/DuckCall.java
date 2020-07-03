package org.example.ch12_compound.simuduck.duck;

import org.example.ch12_compound.simuduck.behaviour.Quackable;

import java.beans.PropertyChangeListener;

public class DuckCall implements Quackable {

    @Override
    public void registerObserver(PropertyChangeListener observer) {
        throw new UnsupportedOperationException("DuckCall is not observable");
    }

    @Override
    public void notifyObservers() {
        throw new UnsupportedOperationException("DuckCall is not observable");
    }

    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
