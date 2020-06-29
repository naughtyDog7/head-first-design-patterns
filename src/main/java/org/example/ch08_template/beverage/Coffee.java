package org.example.ch08_template.beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    protected boolean needCondiments() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you need sugar and milk? (y)");
        String answer;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return answer.toUpperCase().startsWith("Y");
    }
}
