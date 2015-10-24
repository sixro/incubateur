package yodarescue.transaction.ui;

import glue.fx.FXMLUtils;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yodarescue.transaction.domain.BookingID;
import yodarescue.transaction.domain.Repository;
import yodarescue.transaction.domain.RepositoryJDBC;
import yodarescue.util.DataSourceFactory;
import yodarescue.util.DefaulBlockingTask;
import yodarescue.util.TaskUtils;

public class JoinByBookingIdUI implements Initializable {

  private static final Logger LOG = LoggerFactory.getLogger(JoinByBookingIdUI.class);
  
  @FXML private TextField bookingIdTextField;
  @FXML private Button searchButton;
  @FXML private Button generateSqlsButton;
    
  private final Repository repository;
  
  private final SimpleBooleanProperty bookingJoined;
  
  public JoinByBookingIdUI() {
    this(
        new RepositoryJDBC(
            DataSourceFactory.newDataSource(
                System.getProperty("yodarescue.ds.volagratis", "/volagratis-ds-development.properties")
              )
          )
      );
  }

  public JoinByBookingIdUI(Repository repository) {
    super();
    this.repository = repository;

    this.bookingJoined = new SimpleBooleanProperty(true);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    generateSqlsButton.disableProperty().bind(bookingJoined);
    
    bookingIdTextField.setPromptText("e.g. 153630224");
    // FIXME remove
    bookingIdTextField.setText("153630224");
    // already joined 103472763
    
    searchButton.setOnAction(ignored -> {
      BookingID bookingID = BookingID.valueOf(bookingIdTextField.getText());

      DefaulBlockingTask<Boolean> task = new DefaulBlockingTask<Boolean>() {
        @Override
        protected Boolean call() throws Exception {
          boolean joined = repository.isJoined(bookingID);
          LOG.debug("joined: {}", joined);
          return joined;
        }

        @Override
        protected void succeeded() {
          boolean joined = getValue();
          bookingJoined.set(joined);
          
          super.succeeded();
        }
      };
      TaskUtils.run(task);
    });

    generateSqlsButton.setOnAction(ignore -> {
      BookingID bookingID = BookingID.valueOf(bookingIdTextField.getText());
      displayGenerateSqlDialog(bookingID);
    });
  }

  private void displayGenerateSqlDialog(BookingID bookingID) {
    GenerateSqlUI generateSqlUI = new GenerateSqlUI();
    generateSqlUI.setBookingID(bookingID);
    
    Parent parent = (Parent) FXMLUtils.load("/generate-sql.fxml", generateSqlUI);
    Stage dialog = new Stage();
    dialog.setTitle("Generate Sql(s)");
    dialog.initModality(Modality.WINDOW_MODAL);
    Scene scene = new Scene(parent);
    scene.getStylesheets().add("/app.css");
    dialog.setScene(scene);
    
    generateSqlUI.setStage(dialog);
    dialog.showAndWait();
  }

}
