package delilah;

import java.util.List;

public class Menu {
    private final String label;
    private final List<Menu.Item> items;

    public Menu(String label, List<Menu.Item> items) {
        this.label = label;
        this.items = items;
    }

    public String getLabel() {
        return label;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.label != null ? this.label.hashCode() : 0);
        hash = 83 * hash + (this.items != null ? this.items.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
            return false;
        }
        if (this.items != other.items && (this.items == null || !this.items.equals(other.items))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "label=" + label + ", items=" + items + '}';
    }
    
    public static class Item {
        private final String icon;
        private final String label;
        private final String url;

        public Item(String icon, String label, String url) {
            this.icon = icon;
            this.label = label;
            this.url = url;
        }

        public String getIcon() {
            return icon;
        }

        public String getLabel() {
            return label;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + (this.icon != null ? this.icon.hashCode() : 0);
            hash = 79 * hash + (this.label != null ? this.label.hashCode() : 0);
            hash = 79 * hash + (this.url != null ? this.url.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Item other = (Item) obj;
            if ((this.icon == null) ? (other.icon != null) : !this.icon.equals(other.icon)) {
                return false;
            }
            if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
                return false;
            }
            if ((this.url == null) ? (other.url != null) : !this.url.equals(other.url)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Menu.Item{" + "icon=" + icon + ", label=" + label + ", url=" + url + '}';
        }
        
    }
}
