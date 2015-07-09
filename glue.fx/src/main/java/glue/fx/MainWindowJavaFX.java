package glue.fx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainWindowJavaFX implements MainWindow, Initializable {

  @SuppressWarnings("unused")
  private static final Logger LOG = LoggerFactory.getLogger(MainWindowJavaFX.class);
  
  @FXML private AnchorPane       gluefxRoot;
  @FXML private SplitPane        gluefxSplitPane;
  @FXML private AnchorPane       gluefxLogoAndOutlineView;
  @FXML private ImageView        gluefxLogo;
  @FXML private TreeView<String> gluefxOutlineTreeView;
  @FXML private TabPane          gluefxPanelsContainer;
  @FXML private FlowPane         gluefxStatusBar;
  
  private Stage primaryStage;
  
  private OutlineViewJavaFX outlineView;
  private PanelsContainerJavaFX panelsContainer;

  public MainWindowJavaFX() {
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }
  
  @Override
  public void setLogo(Image image, Color backgroundColor) {
    gluefxLogo.setImage(image);
    gluefxLogo.setFitWidth(image.getWidth());
    gluefxLogo.setFitHeight(image.getHeight());
    String colorAsRGB = String.format( "#%02X%02X%02X",
        (int)( backgroundColor.getRed() * 255 ),
        (int)( backgroundColor.getGreen() * 255 ),
        (int)( backgroundColor.getBlue() * 255 ) );
    gluefxLogoAndOutlineView.setStyle("-fx-background-color: " + colorAsRGB);

    AnchorPane.setTopAnchor(gluefxOutlineTreeView, image.getHeight());
    gluefxLogoAndOutlineView.setMinWidth(image.getWidth());
  }

  @Override
  public void setTitle(String title) {
    primaryStage.setTitle(title);
  }

  @Override
  public void show() {
    primaryStage.show();
  }

  @Override
  public synchronized OutlineView getOutlineView() {
    if (outlineView == null) {
      outlineView = new OutlineViewJavaFX(gluefxOutlineTreeView);
      PanelsContainerJavaFX panelsContainer = (PanelsContainerJavaFX) getPanelsContainer();
      outlineView.addListener(panelsContainer);
    }
    return outlineView;
  }

  @Override
  public synchronized PanelsContainer getPanelsContainer() {
    if (panelsContainer == null) {
      panelsContainer = new PanelsContainerJavaFX(gluefxPanelsContainer);
    }
    return panelsContainer;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
