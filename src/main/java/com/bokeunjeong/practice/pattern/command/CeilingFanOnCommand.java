package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.CeilingFan;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CeilingFanOnCommand implements Command {

    CeilingFan ceilingFan;

    @Override
    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {

    }
}
