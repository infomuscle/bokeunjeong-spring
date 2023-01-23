package com.bokeunjeong.practice.pattern.command.receiver;

import com.bokeunjeong.practice.pattern.command.util.LocationUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Stereo {

    String location;

    public void on() {
        System.out.println(LocationUtil.addLocation(location) + "stereo is on");
    }

    public void off() {
        System.out.println(LocationUtil.addLocation(location) + "stereo is off");
    }

    public void setCD() {
        System.out.println(LocationUtil.addLocation(location) + "stereo is set for CD input");
    }

    public void setDVD() {
        System.out.println(LocationUtil.addLocation(location) + "stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(LocationUtil.addLocation(location) + "stereo is set for Radio");
    }

    public void setVolume(int volume) {
        System.out.println(LocationUtil.addLocation(location) + "stereo volume set to " + volume);
    }
}
