package org.example.ch11_proxy.remote.state.impl;

import org.example.ch11_proxy.remote.machine.GumballMachine;
import org.example.ch11_proxy.remote.state.GumReleaseState;

public class WinnerState implements GumReleaseState {
    private static final long serialVersionUID = 109871603723278403L;
    private final transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void dispense() {
        if (gumballMachine.releaseBall()) {
            System.out.println("Congrats! You are a lucky winner" +
                    "\nTake your first gumball");
        } else {
            gumballMachine.getSoldState().dispense();
        }
        if (gumballMachine.releaseBall()) {
            System.out.println("Take your second gumball");
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("Sorry, but we have only one gumball left, " +
                    "so you will take it for free" +
                    "\nTake your coin back");
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
