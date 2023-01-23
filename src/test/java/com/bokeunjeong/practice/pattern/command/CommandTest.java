package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.invoker.RemoteControl;
import com.bokeunjeong.practice.pattern.command.invoker.RemoteControlWithUndo;
import com.bokeunjeong.practice.pattern.command.invoker.SimpleRemoteControl;
import com.bokeunjeong.practice.pattern.command.receiver.*;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    void testSimpleRemote() {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageOpen = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }

    @Test
    void testRemoteLoader() {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, ceilingFanOn, ceilingFanOff);
        remote.setCommand(3, stereoOnWithCd, stereoOff);

        System.out.println(remote);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.onButtonWasPushed(1);
        remote.offButtonWasPushed(1);
        remote.onButtonWasPushed(2);
        remote.offButtonWasPushed(2);
        remote.onButtonWasPushed(3);
        remote.offButtonWasPushed(3);
    }

    @Test
    void testRemoteWithUndo() {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        System.out.println(remote);
        remote.undoButtonWasPushed();
        remote.offButtonWasPushed(0);
        remote.onButtonWasPushed(0);
        System.out.println(remote);
        remote.undoButtonWasPushed();
    }

    @Test
    void testRemoteWithUndo2() {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remote.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remote.setCommand(1, ceilingFanHigh, ceilingFanOff);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        System.out.println(remote);
        remote.undoButtonWasPushed();

        remote.onButtonWasPushed(1);
        System.out.println(remote);
        remote.undoButtonWasPushed();

    }

    @Test
    void testMacroCommand() {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        TVOnCommand tvOn = new TVOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TVOffCommand tvOff = new TVOffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
        Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remote.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remote);
        System.out.println("--- Macro ON ---");
        remote.onButtonWasPushed(0);
        System.out.println("--- Macro OFF ---");
        remote.offButtonWasPushed(0);
    }
}
