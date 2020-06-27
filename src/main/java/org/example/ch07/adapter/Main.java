package org.example.ch07.adapter;

import lombok.extern.slf4j.Slf4j;
import org.example.ch07.adapter.duck.Duck;
import org.example.ch07.adapter.duck.MallardDuck;
import org.example.ch07.adapter.turkey.Turkey;
import org.example.ch07.adapter.turkey.WildTurkey;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        Duck turkeyAsDuck = new TurkeyAdapter(turkey);

        System.out.println("DUCK TEST");
        testDuck(duck);
        System.out.println("========================");
        System.out.println("TURKEY AS DUCK TEST");
        testDuck(turkeyAsDuck);
        System.out.println("========================");

    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
