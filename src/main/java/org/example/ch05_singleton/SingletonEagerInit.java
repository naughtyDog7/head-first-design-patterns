package org.example.ch05_singleton;

/*Singleton with eagerly initialization

Thread-safe
No lazy initialization
Creates instance when class is loaded*/

public class SingletonEagerInit {
    private static final SingletonEagerInit instance = new SingletonEagerInit("INFO");
    private final String info;

    private SingletonEagerInit(String info) {
        this.info = info;
    }

    public static SingletonEagerInit getInstance() {
        return instance;
    }

    public String getInfo() {
        return info;
    }
}
