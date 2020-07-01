package org.example.ch10_state.machine;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.example.ch10_state.state.State;
import org.example.ch10_state.state.impl.*;

import static lombok.AccessLevel.NONE;

@ToString
@Data
public class GumballMachine {

    @Setter(NONE)
    private int numOfGumballs = 0;

    private State state;

    @ToString.Exclude
    private final State soldState;

    @ToString.Exclude
    private final State hasCoinState;

    @ToString.Exclude
    private final State noCoinState;

    @ToString.Exclude
    private final State soldOutState;

    @ToString.Exclude
    private final State winnerState;

    public GumballMachine(int numOfGumballs) {
        noCoinState = new NoCoinState(this);
        soldState = new SoldState(this);
        hasCoinState = new HasCoinState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);

        this.numOfGumballs = numOfGumballs;
        state = numOfGumballs > 0 ? noCoinState : soldOutState;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }


    public void turnCrank() {
        if(state.turnCrank())
            state.dispense();
    }

    /**
     * @return true if successfully released
     */
    public boolean releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (numOfGumballs > 0) {
            numOfGumballs--;
            return true;
        }
        return false;
    }

    public void refill(int numOfGumballs) {
        this.numOfGumballs += numOfGumballs;
        state.refill();
    }
}
