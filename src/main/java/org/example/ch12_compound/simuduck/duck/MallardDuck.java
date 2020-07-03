package org.example.ch12_compound.simuduck.duck;

import org.example.ch12_compound.simuduck.behaviour.Quackable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MallardDuck implements Quackable {
    private final PropertyChangeSupport support;

    public MallardDuck() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }

    @Override
    public void notifyObservers() {
        support.firePropertyChange("quack", false, true);
    }
}
