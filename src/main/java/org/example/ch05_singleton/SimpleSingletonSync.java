package org.example.ch05_singleton;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

/**
 * <b>Simple singleton with synchronized</b><br><br>
 * <p>
 * Thread-safe<br>
 */
@Data
public class SimpleSingletonSync {
    @Getter(AccessLevel.NONE)
    private static SimpleSingletonSync instance;

    private final String info;

    private SimpleSingletonSync(String info) {
        this.info = info;
    }

    /**
     * every getInstance() call is synchronized --> less performance
     *
     * @return Singleton instance
     */
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
