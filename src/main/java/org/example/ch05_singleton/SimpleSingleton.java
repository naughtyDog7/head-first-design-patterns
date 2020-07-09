package org.example.ch05_singleton;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

/**
 * <b>Simple singleton without synchronized</b><br>
 * <p>
 * No thread-safety<br>
 * Lazy initialization<br>
 */
@Data
public class SimpleSingleton {
    @Getter(AccessLevel.NONE)
    private static SimpleSingleton instance;

    private final String info;

    private SimpleSingleton(String info) {
        this.info = info;
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton("INFO");
        }
        return instance;
    }

    public String getInfo() {
        return info;
    }
}
