package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Light;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightOnCommand implements Command {

    Light light;

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
