package org.example.ch05_singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.example.ch05_singleton.SimpleSingleton.getInstance;
import static org.junit.jupiter.api.Assertions.assertSame;

@Slf4j
class SimpleSingletonTest {

    @BeforeAll
    static void setup() {
        log.info("Simple Singleton test");
    }

    @Test
    void comparingSingletons() {
        SimpleSingleton first = getInstance();
        SimpleSingleton second = getInstance();
        assertSame(first, second);
    }
}