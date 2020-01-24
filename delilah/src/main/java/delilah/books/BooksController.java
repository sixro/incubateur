package delilah.books;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BooksController {

    private static final Logger LOG = LoggerFactory.getLogger(BooksController.class);
    
    @GetMapping("/books")
    @ResponseBody
    public List<Book> find() {
        try { Thread.sleep(new Random().nextInt(3000) + 500); }
        catch (InterruptedException ex) { }
        
        return Arrays.asList(
            new Book("https://getmdl.io/assets/demos/welcome_card.jpg", "The Fallen", "Davide Baldacci", "A good book"),
            new Book("https://getmdl.io/assets/demos/dog.png", "La Divina Commedia", "Dante", "'na noia...")
        );
    }
        
}
