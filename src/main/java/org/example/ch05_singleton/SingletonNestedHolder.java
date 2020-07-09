package org.example.ch05_singleton;

import lombok.Data;

/**
 * <b>Singleton with nested SingletonHolder class</b><br><br>
 * <p>
 * Thread-safe<br>
 * Lazy init<br>
 * High performance<br>
 *
 * jvm loads nested class only when getInstance() method is called
 * INSTANCE singleton holder initialization happens on demand<br>
 */
@Data
public class SingletonNestedHolder {
    private final String info;

    private SingletonNestedHolder(String info) {
        this.info = info;
    }

    private static class SingletonHolder {
        private static final SingletonNestedHolder INSTANCE =
                new SingletonNestedHolder("INFO");
    }

    public static SingletonNestedHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getInfo() {
        return info;
    }
}
