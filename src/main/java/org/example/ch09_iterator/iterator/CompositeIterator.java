package org.example.ch09_iterator.iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Optional;

public class CompositeIterator<T extends Iterable<T>> implements Iterator<T> {

    private final Deque<Iterator<T>> elements = new ArrayDeque<>();

    public CompositeIterator(Iterator<T> iterator) {
        elements.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (elements.isEmpty())
            return false;
        Iterator<T> iterator = elements.peek();
        if (!iterator.hasNext()) {
            elements.pop();
            return hasNext();
        } else {
            return true;
        }
    }

    @Override
    public T next() {
        if (hasNext()) {
            Iterator<T> iterator = Optional.ofNullable(elements.peek()).orElseThrow();
            T t = iterator.next();
            elements.push(t.iterator());
            return t;
        }
        return null;
    }
}
