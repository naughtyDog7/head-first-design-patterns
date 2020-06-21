package org.example.ch05_singleton;

import lombok.extern.slf4j.Slf4j;

/*Enum singleton

Thread-safe
Serializable
Reflection access safe
Effectively lazy

Best solution*/

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
