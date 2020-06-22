package org.example.ch02_observer;

import lombok.extern.slf4j.Slf4j;
import org.example.ch02_observer.weather.WeatherStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.example.ch02_observer.display.Display.*;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        WeatherStation station = new WeatherStation();
        station.addListener(currentCondition());
        station.addListener(heatIndex());
        station.addListener(statistic());
        station.addListener(forecast());
        Future<?> stationFuture = executor.submit(station);
        Thread.sleep(10000);
        station.addListener((event) -> log.info("CUSTOM DISPLAY INFO"));
        Thread.sleep(10000);
        station.removeListener(currentCondition());
        executor.awaitTermination(25, TimeUnit.SECONDS);
        executor.shutdown();
        stationFuture.cancel(true);
    }


}
