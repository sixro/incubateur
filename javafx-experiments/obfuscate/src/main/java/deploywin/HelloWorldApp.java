package deploywin;

import org.apache.commons.lang3.StringUtils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class HelloWorldApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        String title = "Obfuscate";
		primaryStage.setTitle(title + " " + StringUtils.length(title));
        Button btn = new Button();
        btn.setText("Obfuscated?");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Obfuscated?");
            }
        });
        
        View view = new View();
        view.addButton(btn);
        primaryStage.setScene(new Scene(view, 300, 250));
        primaryStage.show();
    }
}