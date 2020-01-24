package com.github.sixro.sbafo.menu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainMenu {

    private final List<Menu> menus;

    public MainMenu() {
        this.menus = new LinkedList<>();
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }
    
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    @Override
    public String toString() {
        return "MainMenu{" + "menus=" + menus + '}';
    }
    
}
