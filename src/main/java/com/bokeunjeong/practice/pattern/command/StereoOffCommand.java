package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Stereo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StereoOffCommand implements Command {

    Stereo stereo;

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
