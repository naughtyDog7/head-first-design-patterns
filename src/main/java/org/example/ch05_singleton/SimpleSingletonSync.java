package org.example.ch05_singleton;

/*Simple singleton with synchronized

Thread safe
every getInstance() call is synchronized --> less performance*/

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class SimpleSingletonSync {
    @Getter(AccessLevel.NONE)
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
