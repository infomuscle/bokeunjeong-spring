package com.bokeunjeong.practice.pattern.observer;

import java.util.Map;

public class ForecastDisplay implements Observer, DisplayElement {

    private static Map<Integer, String> MESSAGE = Map.of(
            1, "Improving weather on the way!",
            0, "More of the same",
            -1, "Watch out for cooler, rainy weather");

    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Forecast: %s", MESSAGE.get(Float.compare(currentPressure, lastPressure))));
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
}
