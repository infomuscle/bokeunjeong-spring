package com.bokeunjeong.practice.pattern.command.util;

public class LocationUtil {

    public static String addLocation(String location) {
        if (location != null) {
            return location + " ";
        }
        return "";
    }
}
