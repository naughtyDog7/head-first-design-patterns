package org.example.ch02_observer.display;

import org.example.ch02_observer.display.impl.HeatIndexDisplay;
import org.example.ch02_observer.util.UtilMethods;
import org.example.ch02_observer.weather.WeatherStation.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@FunctionalInterface
public interface Display extends PropertyChangeListener {
    Logger log = LoggerFactory.getLogger(Display.class);

    @Override
    void propertyChange(PropertyChangeEvent evt);

    static Display currentCondition() {
        return (event) -> {
            WeatherData data = UtilMethods.getFromEvent(event);
            log.info("\nCurrent temp: " + data.getTemperature() + "°C\n" +
                    "Current humidity " + data.getHumidity() + "%\n" +
                    "Current pressure " + data.getPressure() + " mm Hg");
        };
    }

    static Display statistic() {
        return (event) -> log.info("Stats: " + "STATS");
    }

    static Display forecast() {
        return (event) -> log.info("Forecast: FORECAST");
    }

    static Display heatIndex() {
        return new HeatIndexDisplay();
    }

}
