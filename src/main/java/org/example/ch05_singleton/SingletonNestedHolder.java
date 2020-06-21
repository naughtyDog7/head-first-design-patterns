package org.example.ch05_singleton;

/*Singleton with nested SingletonHolder class

Thread-safe
Lazy init
High performance

jvm loads nested class only when getInstance() method is called
INSTANCE singleton holder initialization happens on demand
initialization is thread safe*/

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
