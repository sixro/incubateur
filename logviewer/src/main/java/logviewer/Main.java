/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logviewer;

import java.io.IOException;
import java.util.logging.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import logviewer.util.FontAwesome;

/**
 *
 * @author rsimoni
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FontAwesome.init();
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
            Parent root = fxmlLoader.load();
            final MainController mainController = fxmlLoader.getController();
            
            Scene scene = new Scene(root, 1024, 768);
            scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent t) {
                    if (KeyCode.F10.equals(t.getCode())) {
                        mainController.toggleTree();
                    }
                }
            });
            
            primaryStage.setTitle("LogViewer");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
