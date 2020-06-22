package org.example.ch02_observer.display.impl;

import org.example.ch02_observer.display.Display;
import org.example.ch02_observer.weather.WeatherStation.WeatherData;

import java.beans.PropertyChangeEvent;

import static org.example.ch02_observer.util.UtilMethods.*;

public class HeatIndexDisplay implements Display {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WeatherData data = ((WeatherData) evt.getNewValue());
        double heatIndex = toCelsius(getHeatIndex(toFahrenheit(data.getTemperature()), data.getHumidity()));
        log.info("Heat index: " + heatIndex + "°C");
    }

    public double getHeatIndex(double T, int RH) {
        return round2Decimal(-42.379 + 2.04901523 * T + 10.14333127 * RH -
                0.22475541 * T * RH - 0.00683783 * T * T -
                0.05481717 * RH * RH + 0.00122874 * T * T * RH +
                0.00085282 * T * RH * RH - 0.00000199 * T * T * RH * RH);
    }
}
