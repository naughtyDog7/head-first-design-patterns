package org.example.ch11_proxy.remote.state.impl;

import org.example.ch11_proxy.remote.machine.GumballMachine;
import org.example.ch11_proxy.remote.state.State;

import java.util.Random;

public class HasCoinState implements State {
    private static final long serialVersionUID = -3698651593543712918L;
    private final transient GumballMachine gumballMachine;
    private final transient Random rand = new Random();

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert another coin");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned");
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned...");
        if (rand.nextInt(10) == 0)
            gumballMachine.setState(gumballMachine.getWinnerState());
        else
            gumballMachine.setState(gumballMachine.getSoldState());
        return true;
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Should not be here");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
