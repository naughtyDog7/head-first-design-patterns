package org.example.ch01_strategy.behaviour;

import lombok.extern.slf4j.Slf4j;

@FunctionalInterface
public interface Flyable {
    void fly();

    static Flyable flyWithWings() {
        return () -> LogHolder.log.info("flying");
    }

    static Flyable flyNoWings() {
        return () -> LogHolder.log.info("bruh... can't fly");
    }

    @Slf4j
    class LogHolder {
    }
}
