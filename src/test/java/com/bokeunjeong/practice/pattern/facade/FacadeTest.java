package com.bokeunjeong.practice.pattern.facade;

import com.bokeunjeong.practice.pattern.facade.appliance.*;
import org.junit.jupiter.api.Test;

public class FacadeTest {

    @Test
    void testWithoutFacade() {
        Amplifier amp = new Amplifier("Amplifier");
        Tuner tuner = new Tuner("AM/FM Tuner", amp);
        StreamingPlayer player = new StreamingPlayer("Streaming Player", amp);
        CDPlayer cd = new CDPlayer("CD Player", amp);
        Projector projector = new Projector("Projector", player);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        System.out.println("Get ready to watch a movie...");

        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setStreamingPlayer(player);
        amp.setSurroundSound();
        amp.setVolume(5);

        player.on();
        player.play("Raiders of the Lost Ark");


        System.out.println("Shutting movie theater down...");

        popper.off();

        lights.on();

        screen.up();

        projector.off();

        amp.off();

        player.stop();
        player.off();
    }

    @Test
    void testWithFacade() {
        Amplifier amp = new Amplifier("Amplifier");
        Tuner tuner = new Tuner("AM/FM Tuner", amp);
        StreamingPlayer player = new StreamingPlayer("Streaming Player", amp);
        CDPlayer cd = new CDPlayer("CD Player", amp);
        Projector projector = new Projector("Projector", player);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade facade = new HomeTheaterFacade(amp, tuner, player, projector, lights, screen, popper);
        facade.watchMovie("Raiders of the Lost Ark");
        facade.endMovie();
    }
}
