package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Stereo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StereoOnCommand implements Command {

    Stereo stereo;

    @Override
    public void execute() {
        stereo.on();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
