package org.example.ch07.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationAdapter<T> implements Enumeration<T> {
    private final Iterator<T> iterator;

    public static <T> Enumeration<T> fromIterator(Iterator<T> iterator) {
        return new EnumerationAdapter<>(iterator);
    }

    private EnumerationAdapter(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return iterator.next();
    }
}
