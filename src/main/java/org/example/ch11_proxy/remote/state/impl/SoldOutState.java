package org.example.ch11_proxy.remote.state.impl;

import org.example.ch11_proxy.remote.machine.GumballMachine;
import org.example.ch11_proxy.remote.state.State;

public class SoldOutState implements State {
    private static final long serialVersionUID = -6844701375727728704L;
    private final transient GumballMachine gumballMachine;

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
