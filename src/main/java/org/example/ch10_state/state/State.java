package org.example.ch10_state.state;

public interface State {
    void insertCoin();
    void ejectCoin();
    boolean turnCrank();
    void dispense();
    default void refill() {
    }
}
