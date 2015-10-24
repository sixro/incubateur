package yodarescue.transaction.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yodarescue.transaction.domain.BookingID;

public class GenerateSqlUI implements Initializable {

  @FXML private TextField tfBookingID;
  @FXML private Button btnClose;
  
  private SimpleStringProperty bookingID;
  private Stage stage;

  public GenerateSqlUI() {
    super();
    bookingID = new SimpleStringProperty();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    tfBookingID.textProperty().bind(bookingID);
    btnClose.setOnAction(event -> { stage.close(); });
  }

  public void setBookingID(BookingID bookingID) {
    this.bookingID.set(bookingID.getValue());
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

}
