package org.example.ch11_proxy.remote.state;

import java.io.Serializable;

public interface State extends Serializable {
    void insertCoin();
    void ejectCoin();
    boolean turnCrank();
    void dispense();
    default void refill() {
    }
}
