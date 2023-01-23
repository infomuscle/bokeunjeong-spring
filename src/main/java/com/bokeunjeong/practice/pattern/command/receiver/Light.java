package com.bokeunjeong.practice.pattern.command.receiver;

import com.bokeunjeong.practice.pattern.command.util.LocationUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Light {

    String location;

    public void on() {
        System.out.println(LocationUtil.addLocation(location) + "Light is on");
    }

    public void off() {
        System.out.println(LocationUtil.addLocation(location) + "Light is off");
    }
}
