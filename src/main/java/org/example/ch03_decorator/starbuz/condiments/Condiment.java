package org.example.ch03_decorator.starbuz.condiments;

import org.example.ch03_decorator.starbuz.beverages.Beverage;

//class used as decorator
public abstract class Condiment extends Beverage {

    protected final Beverage wrappedObject;

    public Condiment(String description, Beverage wrappedObject) {
        super(description);
        this.wrappedObject = wrappedObject;
    }

    public abstract String getDescription();
}
