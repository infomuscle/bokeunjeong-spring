package com.bokeunjeong.practice.pattern.command.receiver;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Hottub {

    boolean on;
    int temperature;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public void circulate() {
        if (on) {
            System.out.println("Hottub is bubbling!");
        }
    }

    public void jetsOn() {
        if (on) {
            System.out.println("Hottub jets are on");
        }
    }

    public void jetsOff() {
        if (on) {
            System.out.println("Hottub jets are on");
        }
    }

    public void setTemperature(int temperature) {
        if (temperature > this.temperature) {
            System.out.println("Hottub is heating to a steaming " + temperature + " degrees");
        } else {
            System.out.println("Hottub is cooling to " + temperature + " degrees");
        }
        this.temperature = temperature;
    }
}
