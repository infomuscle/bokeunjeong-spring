package com.bokeunjeong.practice.pattern.observer.display;

import com.bokeunjeong.practice.pattern.observer.weather.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions: %sF degrees and %s%% humidity", temperature, humidity));
    }
}
