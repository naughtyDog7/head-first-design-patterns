package org.example.ch01_strategy.duck;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.ch01_strategy.behaviour.Flyable;

import java.util.Optional;

@Data
@Slf4j
public class Duck {
    private Flyable flyImpl;

    public void swim() {
        log.info("swimming");
    }

    public void display() {
        log.info("displaying " + getClass().getSimpleName().replaceAll("([A-Z])", " $1").trim());
    }

    public void tryFly() {
        Optional.ofNullable(flyImpl)
                .orElseThrow(() -> new UnsupportedOperationException("This duck is unable to fly"))
                .fly();
    }

    public void setFlyImpl(Flyable flyImpl) {
        this.flyImpl = flyImpl;
    }
}
