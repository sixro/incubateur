package tryjavafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the main application.
 */
public class TryJavafxApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().add("/main.css");
    stage.setTitle("TryJavafx");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
