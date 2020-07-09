package org.example.ch05_singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * <b>Enum singleton</b>
 * <p>
 * Thread-safe<br>
 * Serializable<br>
 * Reflection access safe<br>
 * Effectively lazy<br>
 * <p><br>
 * <b><i>Best solution</i></b>
 */
@Slf4j
public enum EnumSingleton {
    INSTANCE("INFO");

    private final String info;

    EnumSingleton(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
