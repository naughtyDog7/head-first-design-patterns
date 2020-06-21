package org.example.ch05_singleton;

/*Simple singleton without synchronized

No thread-safety
Lazy initialization*/

public class SimpleSingleton {
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
