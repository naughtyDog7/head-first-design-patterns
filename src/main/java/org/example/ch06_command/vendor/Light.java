package org.example.ch06_command.vendor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Data
public class Light {

    private final AtomicBoolean on = new AtomicBoolean(false);
    private final String room;

    public Light(String room) {
        this.room = room;
    }

    public void on() {
        if (!on.get()) {
            log.info(getClass().getSimpleName() + " on");
            on.set(true);
        } else {
            log.info("Already on");
        }
    }

    public void off() {
        if (on.get()) {
            log.info(getClass().getSimpleName() + " off");
            on.set(false);
        } else {
            log.info("It was off");
        }
    }
}
