package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Hottub;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HottubOffCommand implements Command {

    Hottub hottub;

    @Override
    public void execute() {
        hottub.setTemperature(98);
        hottub.off();
    }

    @Override
    public void undo() {
        hottub.on();
    }
}
