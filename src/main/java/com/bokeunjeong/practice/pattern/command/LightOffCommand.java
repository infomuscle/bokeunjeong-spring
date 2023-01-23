package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Light;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightOffCommand implements Command {

    Light light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
