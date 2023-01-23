package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.GarageDoor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GarageDoorUpCommand implements Command {

    GarageDoor garageDoor;

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}
