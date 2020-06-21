package org.example.ch03_decorator.starbuz.condiments;

import org.example.ch03_decorator.starbuz.beverages.Beverage;

public class Whip extends Condiment {
    public Whip(Beverage wrappedObject) {
        super("Whip", wrappedObject);
    }

    @Override
    public double cost() {
        return wrappedObject.cost() + 1.0;
    }

    @Override
    public String getDescription() {
        return wrappedObject.getDescription() + " with " + description;
    }
}
