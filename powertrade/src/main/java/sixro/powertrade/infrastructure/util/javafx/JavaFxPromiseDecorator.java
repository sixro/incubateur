package sixro.powertrade.infrastructure.util.javafx;

import java.io.*;

import org.jdeferred.Promise;
import org.slf4j.*;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.*;

public class JavaFxPromiseDecorator<D, P> {

	private static final Logger LOG = LoggerFactory.getLogger(JavaFxPromiseDecorator.class);

	private Promise<D, Throwable, P> promise;
	private boolean blockui;
	private boolean errorHandler;

	private Dialog<?> progressWindow;

	private JavaFxPromiseDecorator(Promise<D, Throwable, P> promise) {
		super();
		this.promise = promise;
		this.blockui = false;
		this.errorHandler = false;
	}

	public static <D, P> JavaFxPromiseDecorator<D, P> on(Promise<D, Throwable, P> promise) {
		return new JavaFxPromiseDecorator<>(promise);
	}

	public JavaFxPromiseDecorator<D, P> withBlockUI() {
		this.blockui = true;
		return this;
	}

	public JavaFxPromiseDecorator<D, P> withErrorHandler() {
		this.errorHandler = true;
		return this;
	}

	public Promise<D, Throwable, P> decorate() {
		if (blockui) {
			showProgressWindow();
			promise.always((state, result, reject) -> {
				closeProgressWindow();
			});
		}
		if (errorHandler) {
			promise.fail((t) -> {
				Platform.runLater(() -> {
					StringWriter writer = new StringWriter();
					t.printStackTrace(new PrintWriter(writer));

					Alert alert = new Alert(AlertType.ERROR);
					DialogPane dialogPane = alert.getDialogPane();
					dialogPane.setPrefWidth(800);
					dialogPane.getStylesheets().add(JavaFxPromiseDecorator.class.getResource("/application.css").toExternalForm());
					alert.setHeaderText(t.getMessage());
					alert.setTitle("Error");
					alert.setContentText(writer.toString());
					alert.showAndWait();
				});
			});
		}
		return promise;
	}

	private void showProgressWindow() {
		Platform.runLater(() -> {
			progressWindow = new Dialog<>();
			LOG.info("Loading progress window...");
			Region region = FXML.aFxml().atLocation("/loading.fxml").load();

			progressWindow.initModality(Modality.APPLICATION_MODAL);
			progressWindow.initStyle(StageStyle.UNDECORATED);
			JavaFxUtils.replacePaneContent(progressWindow.getDialogPane(), region);
			progressWindow.getDialogPane().setPrefSize(150, 40);

			LOG.info("... showing progress window...");
			progressWindow.show();
		});
	}

	private void closeProgressWindow() {
		Platform.runLater(() -> {
			LOG.info("... closing progress window...");
			progressWindow.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
			progressWindow.close();
			progressWindow.getDialogPane().getButtonTypes().removeAll(ButtonType.CANCEL);
			LOG.info("... progress window closed");
		});
	}

}
