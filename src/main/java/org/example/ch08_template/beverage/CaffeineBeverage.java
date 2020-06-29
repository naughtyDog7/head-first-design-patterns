package org.example.ch08_template.beverage;

public abstract class CaffeineBeverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (needCondiments())
            addCondiments();

    }

    protected boolean needCondiments() {
        return true;
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    protected void boilWater() {
        System.out.println("Boil water");
    }

    protected void pourInCup() {
        System.out.println("Poor in cup");
    }
}
