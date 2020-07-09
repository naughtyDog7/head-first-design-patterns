package org.example.ch05_singleton;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

/**
 * <b>Double-checked locking singleton</b><br>
 * <p>
 * Thread-safe<br>
 * Lazy initialization<br>
 *
 * @since 1.5
 */
@Data
public class DoubleCheckedSingleton {
    /**
     * Using <b>volatile</b> is important
     */
    @Getter(AccessLevel.NONE)
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
