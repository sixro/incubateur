package com.github.sixro.sbafo.demo;

// TODO come cazzo si importa sta classe di merda?

import com.github.sixro.sbafo.menu.MainMenu;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(WebApplication.class);
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
    
    // Create a MainMenu using application properties
    @Bean(name="rawMenu")
    @ConfigurationProperties(prefix = "mainMenu")
    public Map<String, Map<String, String>> getRawMenu() {
        return new LinkedHashMap<String, Map<String, String>>();
    }

    @Bean
    public MainMenu getMainMenu(@Qualifier("rawMenu") Map<String, Map<String, String>> rawMenu) {
        LOG.info("mainMenuParam: {}", rawMenu);
        return MainMenuFactory.newMainMenu(rawMenu);
    }

    // Create a MainMenu programmatically
//    @Bean
//    public MainMenu getMainMenu() {
//        final MainMenu mainmenu = new MainMenu();
//        Menu fileMenu = new Menu("inbox", "File");
//        fileMenu.addItem(new MenuItem("star", "Inbox", "myID"));
//        fileMenu.addItem(new MenuItem("send", "Outbox", "myID"));
//        Menu editMenu = new Menu("email", "Edit");
//        editMenu.addItem(new MenuItem("delete", "Inbox", "myID"));
//        editMenu.addItem(new MenuItem("report", "Outbox", "myID"));
//        mainmenu.addMenu(fileMenu);
//        mainmenu.addMenu(editMenu);
//        return mainmenu;
//    }
    
}
