package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Hottub;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HottubOnCommand implements Command {

    Hottub hottub;

    @Override
    public void execute() {
        hottub.on();
        hottub.setTemperature(104);
        hottub.circulate();
    }

    @Override
    public void undo() {
        hottub.off();
    }
}
