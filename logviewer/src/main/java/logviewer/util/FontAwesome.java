package logviewer.util;

import javafx.scene.text.Font;
import logviewer.Main;

public class FontAwesome {

    private static final Font FONT = Font.loadFont(
        Main.class.getResource("/fonts/fontawesome-webfont.ttf").toExternalForm(),
        10
    );

    public static final String HEART       = "\uf004";
    public static final String HEART_EMPTY = "\uf08a";
    
    private FontAwesome() { }

    public static void init() { }
    
    public static Font font() {
        return FONT;
    }
    
}
