package com.github.sixro.sbafo.menu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Menu {

    private final Object icon;
    private final String label;
    private final List<MenuItem> items;

    public Menu(Object icon, String label) {
        this.icon = icon;
        this.label = label;
        this.items = new LinkedList<>();
    }

    public Object getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
    
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Menu{" + "icon=" + icon + ", label=" + label + ", items=" + items + '}';
    }
    
}
