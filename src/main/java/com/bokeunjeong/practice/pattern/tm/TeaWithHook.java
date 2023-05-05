package com.bokeunjeong.practice.pattern.tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    public boolean customerWantsCondiments() {
        // String answer = getUserInput();
        String answer = "y";

        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        System.out.println("??");
        String answer = null;
        System.out.print("Would you like lemon with your tea (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }
}
