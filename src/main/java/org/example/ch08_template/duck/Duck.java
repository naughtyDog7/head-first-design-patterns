package org.example.ch08_template.duck;

import lombok.Data;

@Data
public class Duck implements Comparable<Duck> {

    private String name;
    private int weight;

    @Override
    public int compareTo(Duck o) {
        return Integer.compare(weight, o.weight);
    }
}
