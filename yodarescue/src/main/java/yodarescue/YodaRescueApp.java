package yodarescue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import glue.fx.ImageFactory;
import glue.fx.MainWindow;
import glue.fx.MainWindowJavaFXFactory;
import glue.fx.OutlineView;
import glue.fx.OutlineView.ActionGroup;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class YodaRescueApp extends Application {

  private static final Logger LOG = LoggerFactory.getLogger(YodaRescueApp.class);
  
  @Override
  public void start(Stage stage) throws Exception {
    MainWindow mainWindow = MainWindowJavaFXFactory.newMainWindow(stage);
    mainWindow.setLogo(ImageFactory.newImage("/logo.png"), Color.WHITE);
    mainWindow.setTitle("Yoda Rescue");
    
    OutlineView outlineView = mainWindow.getOutlineView();
    LOG.debug("outlineView: {}", outlineView);
    ActionGroup transactionsActionGroup = outlineView.addActionGroup("TRANSACTIONS");
    transactionsActionGroup.addAction("List orphane", "/list-orphane.fxml");
    transactionsActionGroup.addAction("Join by Booking ID", "/join-by-bookingID.fxml");
    
    mainWindow.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
