package com.bokeunjeong.practice.pattern.tm.list;

import java.util.AbstractList;

public class MyStringList extends AbstractList<String> {

    private String[] myList;

    public MyStringList(String[] strings) {
        this.myList = strings;
    }

    @Override
    public String get(int index) {
        return myList[index];
    }

    @Override
    public int size() {
        return myList.length;
    }

    @Override
    public String set(int index, String item) {
        String oldString = myList[index];
        myList[index] = item;

        return oldString;
    }
}
