package org.example.ch10_state.state.impl;

import org.example.ch10_state.machine.GumballMachine;
import org.example.ch10_state.state.GumReleaseState;

public class SoldState implements GumReleaseState {
    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void dispense() {
        if (gumballMachine.releaseBall()) {
            System.out.println("Take your gumball");
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("Oops, we are sold out, take your coin back");
            gumballMachine.setState(gumballMachine.getHasCoinState());
            gumballMachine.ejectCoin();
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
