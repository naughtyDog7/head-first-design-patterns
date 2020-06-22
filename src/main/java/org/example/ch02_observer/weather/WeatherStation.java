package org.example.ch02_observer.weather;

import lombok.Data;
import lombok.Setter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;
import static lombok.AccessLevel.PRIVATE;
import static org.example.ch02_observer.util.UtilMethods.round2Decimal;

public class WeatherStation implements Runnable {

    private final WeatherData weatherData;
    private final PropertyChangeSupport support;

    public WeatherStation() {
        this.support = new PropertyChangeSupport(this);
        weatherData = new WeatherData();
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                //imitate weather new data receiving
                WeatherData oldWeatherData = new WeatherData();
                oldWeatherData.setTemperature(weatherData.temperature);
                oldWeatherData.setHumidity(weatherData.humidity);
                oldWeatherData.setPressure(weatherData.pressure);

                Thread.sleep(current().nextInt(5000, 10000));

                weatherData.setTemperature(round2Decimal(current().nextDouble(20, 35)));
                weatherData.setHumidity(current().nextInt(10, 15));
                weatherData.setPressure(current().nextInt(760, 765));

                support.firePropertyChange("weatherData", oldWeatherData, weatherData);
            }
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


    @Data
    public static class WeatherData {

        @Setter(value = PRIVATE)
        private double temperature;

        @Setter(value = PRIVATE)
        private int humidity;

        @Setter(value = PRIVATE)
        private int pressure;
    }
}
