package org.example.ch12_compound.simuduck.goose;

import org.example.ch12_compound.simuduck.behaviour.Quackable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GooseQuackable implements Quackable {
    private final PropertyChangeSupport support;

    private final Goose goose;

    public GooseQuackable(Goose goose) {
        this.goose = goose;
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void registerObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }

    @Override
    public void notifyObservers() {
        support.firePropertyChange("honk", false, true);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }
}
