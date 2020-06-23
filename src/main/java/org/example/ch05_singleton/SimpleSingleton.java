package org.example.ch05_singleton;

/*Simple singleton without synchronized

No thread-safety
Lazy initialization*/

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

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
