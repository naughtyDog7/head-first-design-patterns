package org.example.ch05_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SingletonEagerInitTest {

    @RepeatedTest(10)
    void compareSingletonsInMultithreading() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<SingletonEagerInit> first = executorService.submit(SingletonEagerInit::getInstance);
        Future<SingletonEagerInit> second = executorService.submit(SingletonEagerInit::getInstance);

        Assertions.assertSame(first.get(), second.get());
        executorService.shutdown();
    }

}