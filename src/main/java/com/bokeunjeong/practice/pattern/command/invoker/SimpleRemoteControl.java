package com.bokeunjeong.practice.pattern.command.invoker;

import com.bokeunjeong.practice.pattern.command.Command;

public class SimpleRemoteControl {

    Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

}
