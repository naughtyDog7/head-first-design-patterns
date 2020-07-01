package org.example.ch10_state.state;

public interface GumReleaseState extends State {
    @Override
    default void insertCoin() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    default void ejectCoin() {
        System.out.println("Late to eject, already turned the crank");
    }

    @Override
    default boolean turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
        return false;
    }
}
