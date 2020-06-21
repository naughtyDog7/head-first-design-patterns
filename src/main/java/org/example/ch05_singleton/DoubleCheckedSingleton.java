package org.example.ch05_singleton;

/*Double-checked locking singleton

Thread-safe
Lazy initialization
Using volatile is recommended
Only from java 1.5*/

public class DoubleCheckedSingleton {
    private volatile static DoubleCheckedSingleton instance;
    private final String info;

    private DoubleCheckedSingleton(String info) {
        this.info = info;
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton("INFO");
                }
            }
        }
        return instance;
    }

    public String getInfo() {
        return info;
    }
}
