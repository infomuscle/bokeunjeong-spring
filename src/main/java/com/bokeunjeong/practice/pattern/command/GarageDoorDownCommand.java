package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.GarageDoor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GarageDoorDownCommand implements Command {

    GarageDoor garageDoor;

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {

    }
}
