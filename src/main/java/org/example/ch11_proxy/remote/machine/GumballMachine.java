package org.example.ch11_proxy.remote.machine;

import lombok.Data;
import lombok.Setter;
import org.example.ch11_proxy.remote.remote.GumballMachineRemote;
import org.example.ch11_proxy.remote.state.State;
import org.example.ch11_proxy.remote.state.impl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

import static lombok.AccessLevel.NONE;

@Data
public class GumballMachine extends UnicastRemoteObject
        implements GumballMachineRemote {

    private static final long serialVersionUID = -2492607181197989665L;
    @Setter(NONE)
    private int numOfGumballs = 0;

    private final String location;

    private State state;

    private final State soldState;
    private final State hasCoinState;
    private final State noCoinState;
    private final State soldOutState;
    private final State winnerState;

    public GumballMachine(String location, int numOfGumballs) throws RemoteException {
        super();
        this.location = location;
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

    @Override
    public String toString() {
        return "GumballMachine{" +
                "numOfGumballs=" + numOfGumballs +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GumballMachine that = (GumballMachine) o;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
