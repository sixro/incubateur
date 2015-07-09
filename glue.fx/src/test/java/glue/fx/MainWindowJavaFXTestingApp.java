package glue.fx;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindowJavaFXTestingApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    MainWindow mainWindow = MainWindowJavaFXFactory.newMainWindow(primaryStage);
    mainWindow.setLogo(ImageFactory.newImage("/logo.png"), Color.web("ff8888"));
    mainWindow.show();
  }

  public static void main(String... args) {
    launch(args);
  }
}
