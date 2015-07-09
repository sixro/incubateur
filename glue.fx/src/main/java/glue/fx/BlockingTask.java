package glue.fx;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public abstract class BlockingTask<T> extends Task<T> {

  private final Alert messageBox;
  
  private EventHandler<WorkerStateEvent> onDone;
  
  public BlockingTask(String message, String styles) {
    super();
    this.messageBox = new Alert(AlertType.INFORMATION, message, ButtonType.CANCEL);
    this.messageBox.setHeaderText("");
    this.messageBox.initStyle(StageStyle.UNDECORATED);
    this.messageBox.getDialogPane().setStyle(styles);
    this.messageBox.resultProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue.getButtonData().isCancelButton())
        cancel();
    });
    
    this.onDone = null;
  }

  // TODO a factory method creating a BlockingTask with a Callable<V>
  
  public EventHandler<WorkerStateEvent> getOnDone() {
    return onDone;
  }
  
  public void setOnDone(EventHandler<WorkerStateEvent> eventHandler) {
    this.onDone = eventHandler;
  }

  @Override
  protected void running() {
    messageBox.show();
    
    super.running();
  }

  @Override
  protected void succeeded() {
    messageBox.close();
    done();

    super.succeeded();
  }

  @Override
  protected void cancelled() {
    messageBox.close();
    done();

    super.cancelled();
  }

  @Override
  protected void failed() {
    messageBox.close();
    done();

    super.failed();
  }
  
  protected void done() {
    if (onDone != null)
      onDone.handle(null);
  }
  
}
