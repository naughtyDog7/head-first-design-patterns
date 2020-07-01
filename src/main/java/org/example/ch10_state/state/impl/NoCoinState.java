package org.example.ch10_state.state.impl;

import org.example.ch10_state.machine.GumballMachine;
import org.example.ch10_state.state.State;

public class NoCoinState implements State {
    private final GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a coin");
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned, but there is no coin");
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
}
