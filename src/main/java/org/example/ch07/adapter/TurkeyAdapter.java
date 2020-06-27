package org.example.ch07.adapter;

import lombok.RequiredArgsConstructor;
import org.example.ch07.adapter.duck.Duck;
import org.example.ch07.adapter.turkey.Turkey;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class TurkeyAdapter implements Duck {
    private final Turkey turkey;

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        IntStream.range(0, 5)
                .forEach(i -> turkey.fly());
    }
}
