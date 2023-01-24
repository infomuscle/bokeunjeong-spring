package com.bokeunjeong.practice.pattern.adapter.iterator;

import lombok.AllArgsConstructor;

import java.util.Enumeration;
import java.util.Iterator;

@AllArgsConstructor
public class EnumerationIterator<T> implements Iterator<T> {

    Enumeration<T> enumeration;

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
