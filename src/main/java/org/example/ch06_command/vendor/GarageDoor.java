package org.example.ch06_command.vendor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Data
public class GarageDoor {
    private final AtomicBoolean opened = new AtomicBoolean(false);
    private final Light light;

    public GarageDoor(Light light) {
        this.light = light;
    }

    public void up() {
        if (!opened.get()) {
            log.info("Opening garage");
            opened.set(true);
        } else {
            log.info("Already opened");
        }
    }

    public void down() {
        if (opened.get()) {
            log.info("Closing garage");
            opened.set(false);
        } else {
            log.info("Already closed");
        }
    }

    public void stop() {
        log.info("Stop");
    }

    public void lightOn() {
        light.on();
    }

    public void lightOff() {
        light.off();
    }
}
