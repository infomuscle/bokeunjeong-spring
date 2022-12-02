package com.bokeunjeong.practice.pattern.observer.weather;

import com.bokeunjeong.practice.pattern.observer.display.Observer;

public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
