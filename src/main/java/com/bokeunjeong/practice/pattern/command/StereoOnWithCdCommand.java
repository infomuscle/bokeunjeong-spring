package com.bokeunjeong.practice.pattern.command;

import com.bokeunjeong.practice.pattern.command.receiver.Stereo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StereoOnWithCdCommand implements Command {

    Stereo stereo;

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {

    }
}
