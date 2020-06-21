package org.example.ch05_singleton;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, CloneNotSupportedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<Singleton> singleton1 = executorService.submit(Singleton::getInstance);
//        Future<Singleton> singleton2 = executorService.submit(Singleton::getInstance);
//        log.info(singleton1.get().toString());
//        log.info(singleton2.get().toString());
//        Future<Singleton> singleton3 = executorService.submit(Singleton::getInstance);
//        log.info(singleton3.get().toString());
//        executorService.shutdown();
//
//        System.out.println(EnumSingleton.getInstance());
//        System.out.println(EnumSingleton.getInstance());
//        System.out.println(EnumSingleton.getInstance().getClass().getName());

        System.out.println(Boolean.valueOf(false));
        System.out.println(BigInteger.valueOf(6).isProbablePrime(256));

    }
}
