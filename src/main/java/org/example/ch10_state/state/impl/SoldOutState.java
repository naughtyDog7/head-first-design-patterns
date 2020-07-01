package org.example.ch10_state.state.impl;

import org.example.ch10_state.machine.GumballMachine;
import org.example.ch10_state.state.State;

public class SoldOutState implements State {
    private final GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert a coin, the machine is sold out");
    }

    @Override
    public void ejectCoin() {
        System.out.println("What coin are you talking about");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned, but there are no gumballs");
        return false;
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Should not be here");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }
}
