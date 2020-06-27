package org.example.ch07.adapter;

import lombok.RequiredArgsConstructor;
import org.example.ch07.adapter.duck.Duck;
import org.example.ch07.adapter.turkey.Turkey;

@RequiredArgsConstructor
public class DuckAdapter implements Turkey {
    private final Duck duck;

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        System.out.println("Flying short distance");
    }
}
