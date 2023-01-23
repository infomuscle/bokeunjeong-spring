package com.bokeunjeong.practice.pattern.command.receiver;

import com.bokeunjeong.practice.pattern.command.util.LocationUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TV {

    String location;
    int channel;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(LocationUtil.addLocation(location) + "TV is on");
    }

    public void off() {
        System.out.println(LocationUtil.addLocation(location) + "TV is off");
    }

    public void setInputChannel() {
        this.channel = 3;
        System.out.println(LocationUtil.addLocation(location) + "TV channel is set for DVD");
    }
}
