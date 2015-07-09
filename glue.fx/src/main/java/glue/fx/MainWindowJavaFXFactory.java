package glue.fx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a factory of {@link MainWindow} using JavaFX.
 */
public class MainWindowJavaFXFactory {

  private static final Logger LOG = LoggerFactory.getLogger(MainWindowJavaFXFactory.class);
  
  private MainWindowJavaFXFactory() { }
  
  /**
   * Returns a {@link MainWindow} &quot;attached&quot; to the specified primary {@link Stage}.
   * 
   * <p>
   * The {@link Stage} to pass to this call has to be the {@link Stage} obtained by the
   * {@link Application#start(Stage)}.
   * </p>
   * 
   * @param primaryStage a {@link Stage}
   * @return a {@link MainWindow}
   */
  public static MainWindow newMainWindow(Stage primaryStage) {
    LOG.info("creating MainWindow in JavaFX...");
    
    LOG.debug("... creating controller...");
    MainWindowJavaFX mainWindow = new MainWindowJavaFX();

    LOG.debug("... loading view...");
    Parent root = (Parent) FXMLUtils.load("/glue/fx/mainWindow.fxml", mainWindow);

    LOG.debug("... creating Scene...");
    Scene scene = new Scene(root, 800, 600);
    LOG.debug("... setting application stylesheet (/app.css)...");
    scene.getStylesheets().add("/app.css");
    primaryStage.setScene(scene);
    
    LOG.debug("... setting primaryStage to mainWindow...");
    mainWindow.setPrimaryStage(primaryStage);
    
    LOG.info("... returning " + mainWindow);
    return mainWindow;
  }

}
