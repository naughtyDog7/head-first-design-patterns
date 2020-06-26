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
            System.out.println("\uD83D\uDCA1" + " on");
            on.set(true);
        } else {
            System.out.println("\uD83D\uDCA1" + " Already on");
        }
    }

    public void off() {
        if (on.get()) {
            System.out.println("\uD83D\uDD0C" + " off");
            on.set(false);
        } else {
            System.out.println("\uD83D\uDD0C" + " It was off");
        }
    }
}
