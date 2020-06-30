package org.example.ch09_iterator.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.ch09_iterator.iterator.NullIterator;

import java.util.Iterator;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MenuItem extends MenuComponent {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return new NullIterator<>();
    }

    @Override
    public String toString() {
        return "-- " + name + " "
                + price + ", -- " +
                description +
                (vegetarian ? " (veg)" : "");
    }
}
