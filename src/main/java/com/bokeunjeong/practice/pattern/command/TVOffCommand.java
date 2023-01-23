package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.TV;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TVOffCommand implements Command {

    TV tv;

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
