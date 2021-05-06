package delilah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);
    
    @GetMapping("/")
    public String home(Map<String, Object> model) {
//        model.put("time", new Date());
//        model.put("message", "Hello world");
//        
//        LOG.info("main menu: {}", mainMenu.getMenus().size());
//        model.put("mainMenu", mainMenu);
        
        return "app";
    }

    @GetMapping("/menu")
    @ResponseBody
    public List<Menu> menu(Map<String, Object> model) {
        return Arrays.asList(
            new Menu("Staff", Arrays.asList(
                new Menu.Item("star", "Books", "#books"),
                new Menu.Item("star", "Albums", "#albums")
            )),
            new Menu("About", Arrays.asList(
                new Menu.Item("star", "Credits", "#credits")
            ))                
        );
    }

}
