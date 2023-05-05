package com.bokeunjeong.practice.pattern.tm;

import com.bokeunjeong.practice.pattern.tm.list.MyStringList;
import com.bokeunjeong.practice.pattern.tm.sort.Duck;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TemplateMethodTest {

    @Test
    void test() {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("\nMaking tea...");
        tea.prepareRecipie();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipie();


        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipie();

        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipie();
    }

    @Test
    void testSort() {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };

        System.out.println("Before sorting: ");
        display(ducks);

        System.out.println();

        Arrays.sort(ducks);
        System.out.println("After sorting: ");
        display(ducks);
    }

    private void display(Duck[] ducks) {
        for (Duck duck : ducks) {
            System.out.println(duck);
        }
    }

    @Test
    void testList() {
        String[] ducks = {"Mallard Duck", "Readhead Duck", "Rubber Duck", "Decoy Duck"};

        MyStringList ducksList = new MyStringList(ducks);
        for (int i = 0; i < ducksList.size(); i++) {
            System.out.println(ducksList.get(i));
        }

        System.out.println();

        List ducksSubList = ducksList.subList(2, 3);
        System.out.println("Created a sub list of ducks, with size: " + ducksSubList.size());
        for (int i = 0; i < ducksSubList.size(); i++) {
            System.out.println(ducksSubList.get(i));
        }
    }
}

