package com.bokeunjeong.practice.pattern.command.receiver;

import com.bokeunjeong.practice.pattern.command.util.LocationUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GarageDoor {

    String location;

    public void up() {
        System.out.println(LocationUtil.addLocation(location) + "Garage Door is Open");
    }

    public void down() {
        System.out.println(LocationUtil.addLocation(location) + "Garage Door is Closed");
    }

    public void stop() {
        System.out.println(LocationUtil.addLocation(location) + "Garage Door is Stopped");
    }

    public void lightOn() {
        System.out.println(LocationUtil.addLocation(location) + "Garage light is on");
    }

    public void lightOff() {
        System.out.println(LocationUtil.addLocation(location) + "Garage light is off");
    }
}
