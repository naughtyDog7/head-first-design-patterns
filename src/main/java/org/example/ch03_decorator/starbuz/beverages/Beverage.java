package org.example.ch03_decorator.starbuz.beverages;

import org.example.ch03_decorator.starbuz.ingredient.Ingredient;

import java.util.List;

public abstract class Beverage {
    protected final String description;
    protected List<Ingredient> ingredients;
    private Size size;

    public Beverage(String description) {
        this.description = description;
    }

    public abstract double cost();


    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
