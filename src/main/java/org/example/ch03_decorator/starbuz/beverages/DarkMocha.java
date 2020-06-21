package org.example.ch03_decorator.starbuz.beverages;


public class DarkMocha extends Beverage {
    public DarkMocha() {
        super("Most excellent Dark Mocha");
    }

    @Override
    public double cost() {
        return 4.0;
    }
}
