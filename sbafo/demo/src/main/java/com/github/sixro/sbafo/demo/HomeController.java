package com.github.sixro.sbafo.demo;

import com.github.sixro.sbafo.menu.MainMenu;
import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private MainMenu mainMenu;
    
    @GetMapping("/")
    public String home(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Hello world");
        
        LOG.info("main menu: {}", mainMenu.getMenus().size());
        model.put("mainMenu", mainMenu);
        
        return "home";
    }
        
}
