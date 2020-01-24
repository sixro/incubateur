package com.github.sixro.sbafo.demo;

import com.github.sixro.sbafo.menu.MainMenu;
import com.github.sixro.sbafo.menu.Menu;
import com.github.sixro.sbafo.menu.MenuItem;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMenuFactory {
    
    private static final Logger LOG = LoggerFactory.getLogger(MainMenuFactory.class);
    
    private MainMenuFactory() { }
    
    // FIXME probabilmente il parametro e' una MainMenuDefinition... cosi sta roba e' testabile/documentabile...
    public static MainMenu newMainMenu(Map<String, Map<String, String>> rawMenu) {
        LOG.info("Creating a MainMenu with {}", rawMenu);
        
        String label;
        String icon;
        final MainMenu mainMenu = new MainMenu();
        for (Map.Entry<String, Map<String, String>> entry: rawMenu.entrySet()) {
            final String key = entry.getKey();
            int indexOfParentesis = key.indexOf("(");
            if (indexOfParentesis >= 0) {
                label = key.substring(0, indexOfParentesis);
                icon = key.substring(indexOfParentesis +1, key.indexOf(")"));
            } else {
                label = key;
                icon = "";
            }
            
            Menu menu = new Menu(icon, label);
            for (Map.Entry<String, String> itemEntry: entry.getValue().entrySet()) {
                final String key1 = itemEntry.getKey();
                indexOfParentesis = key1.indexOf("(");
                if (indexOfParentesis >= 0) {
                    label = key1.substring(0, indexOfParentesis);
                    icon = key1.substring(indexOfParentesis +1, key1.indexOf(")"));                    
                } else {
                    label = key1;
                    icon = "";
                }

                menu.addItem(new MenuItem(icon, label, itemEntry.getValue()));
            }
            mainMenu.addMenu(menu);
        }
        LOG.info("... returning {}", mainMenu);
        return mainMenu;
    }
    
}
