package org.example.ch10_state;

import lombok.extern.slf4j.Slf4j;
import org.example.ch10_state.machine.GumballMachine;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();

        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.ejectCoin();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
