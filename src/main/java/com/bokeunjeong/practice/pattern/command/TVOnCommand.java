package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.TV;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TVOnCommand implements Command {

    TV tv;

    @Override
    public void execute() {
        tv.on();
        tv.setInputChannel();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
