package com.github.sixro.sbafo.menu;

public class MenuItem {

    private final Object icon;
    private final String label;
    private final String url;

    public MenuItem(String label, String url) {
        this(null, label, url);
    }

    public MenuItem(Object icon, String label, String url) {
        this.icon = icon;
        this.label = label;
        this.url = url;
    }

    public Object getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "icon=" + icon + ", label=" + label + ", url=" + url + '}';
    }

    
}
