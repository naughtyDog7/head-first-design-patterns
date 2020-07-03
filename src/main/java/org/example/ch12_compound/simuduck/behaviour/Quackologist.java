package org.example.ch12_compound.simuduck.behaviour;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Quackologist implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Quackologist: " + evt.getSource().getClass().getSimpleName() + " just quacked");
    }
}
