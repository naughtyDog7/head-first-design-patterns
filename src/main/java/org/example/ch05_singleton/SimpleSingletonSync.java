package org.example.ch05_singleton;

/*Simple singleton with synchronized

Thread safe
every getInstance() call is synchronized --> less performance*/

public class SimpleSingletonSync {
    private static SimpleSingletonSync instance;
    private final String info;

    private SimpleSingletonSync(String info) {
        this.info = info;
    }

    public synchronized static SimpleSingletonSync getInstance() {
        if (instance == null) {
            instance = new SimpleSingletonSync("INFO");
        }
        return instance;
    }

    public String getInfo() {
        return info;
    }
}
