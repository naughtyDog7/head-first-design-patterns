package org.example.ch09_iterator.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.ch09_iterator.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Menu extends MenuComponent {

    protected List<MenuComponent> menuComponents;
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.menuComponents = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        menuComponents.forEach(MenuComponent::print);
    }

    public List<MenuComponent> getMenuComponents() {
        return List.copyOf(menuComponents);
    }

    private Iterator<MenuComponent> iterator;

    @Override
    public Iterator<MenuComponent> iterator() {
        if (iterator == null) {
            iterator = new CompositeIterator<>(menuComponents.iterator());
        }
        return iterator;
    }

    @Override
    public boolean isVegetarian() {
        return false;
    }
}
