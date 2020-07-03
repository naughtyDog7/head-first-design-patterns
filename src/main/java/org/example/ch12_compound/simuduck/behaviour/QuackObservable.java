package org.example.ch12_compound.simuduck.behaviour;

import java.beans.PropertyChangeListener;

public interface QuackObservable {
    void registerObserver(PropertyChangeListener observer);
    void notifyObservers();
}
