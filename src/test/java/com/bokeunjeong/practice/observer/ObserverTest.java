package com.bokeunjeong.practice.observer;

import com.bokeunjeong.practice.pattern.observer.display.CurrentConditionsDisplay;
import com.bokeunjeong.practice.pattern.observer.display.ForecastDisplay;
import com.bokeunjeong.practice.pattern.observer.display.HeatIndexDisplay;
import com.bokeunjeong.practice.pattern.observer.display.StatisticsDisplay;
import com.bokeunjeong.practice.pattern.observer.weather.WeatherData;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    void test1() {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
