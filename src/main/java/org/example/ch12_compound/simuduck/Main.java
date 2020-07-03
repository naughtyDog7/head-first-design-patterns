package org.example.ch12_compound.simuduck;

import org.example.ch12_compound.simuduck.behaviour.Quackable;
import org.example.ch12_compound.simuduck.behaviour.Quackologist;
import org.example.ch12_compound.simuduck.duck.Flock;
import org.example.ch12_compound.simuduck.duck.factory.AbstractDuckFactory;
import org.example.ch12_compound.simuduck.duck.factory.CountingDuckFactory;
import org.example.ch12_compound.simuduck.goose.Goose;
import org.example.ch12_compound.simuduck.goose.GooseQuackable;

import static org.example.ch12_compound.simuduck.behaviour.QuackCounter.getNumOfQuacks;

public class Main {
    public static void main(String[] args) {
        simulate(new CountingDuckFactory());
    }

    private static void simulate(AbstractDuckFactory factory) {
        Flock flockOfDucks = new Flock();

        Quackable mallardDuck = factory.mallardDuck();
        Quackable redheadDuck = factory.redheadDuck();
        Quackable duckCall = factory.duckCall();
        Quackable rubberDuck = factory.rubberDuck();
        Quackable gooseDuck = new GooseQuackable(new Goose());

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Flock mallardDuckFlock = new Flock();

        Quackable mallardOne = factory.mallardDuck();
        Quackable mallardTwo = factory.mallardDuck();
        Quackable mallardThree = factory.mallardDuck();
        Quackable mallardFour = factory.mallardDuck();

        mallardDuckFlock.add(mallardOne);
        mallardDuckFlock.add(mallardTwo);
        mallardDuckFlock.add(mallardThree);
        mallardDuckFlock.add(mallardFour);

        flockOfDucks.add(mallardDuckFlock);

        Quackologist quackologist = new Quackologist();
        mallardDuckFlock.registerObserver(quackologist);

        System.out.println("\nWhole flock simulation");
        simulate(flockOfDucks);

        System.out.println("\nMallard duck flock simulation");
        simulate(mallardDuckFlock);

        System.out.println("\nTotal ducks count " + getNumOfQuacks());
    }

    private static void simulate(Quackable quackable) {
        quackable.quack();
    }
}
