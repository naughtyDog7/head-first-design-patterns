package org.example.ch05_singleton;

/*Singleton with eagerly initialization

Thread-safe
No lazy initialization
Creates instance when class is loaded*/

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class SingletonEagerInit {
    @Getter(AccessLevel.NONE)
    private static final SingletonEagerInit instance = new SingletonEagerInit("INFO");

    private final String info;

    private SingletonEagerInit(String info) {
        this.info = info;
    }

    public static SingletonEagerInit getInstance() {
        return instance;
    }
}
