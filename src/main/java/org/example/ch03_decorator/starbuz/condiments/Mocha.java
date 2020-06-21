package org.example.ch03_decorator.starbuz.condiments;

import org.example.ch03_decorator.starbuz.beverages.Beverage;

public class Mocha extends Condiment {

    public Mocha(Beverage wrappedObject) {
        super("Mocha", wrappedObject);
    }

    @Override
    public double cost() {
        double sizeMultiplier = 1;
        switch (getSize()) {
            case SMALL:
                sizeMultiplier = 0.5;
                break;
            case LARGE:
                sizeMultiplier = 1.5;
        }
        return wrappedObject.cost() + 2.0 * sizeMultiplier;
    }


    @Override
    public String getDescription() {
        return description + " " + wrappedObject.getDescription();
    }
}
