package org.example.ch02_observer.util;

import org.example.ch02_observer.weather.WeatherStation.WeatherData;

import java.beans.PropertyChangeEvent;

public class UtilMethods {
    public static double round2Decimal(double num) {
        return Math.round(num * 100) / 100.0;
    }

    public static double toFahrenheit(double tempInCelsius) {
        return tempInCelsius * (9 / 5.0) + 32;
    }

    public static double toCelsius(double tempInFahrenheit) {
        return (tempInFahrenheit - 32) * (5 / 9.0);
    }

    public static WeatherData getFromEvent(PropertyChangeEvent event) {
        return ((WeatherData) event.getNewValue());
    }
}
