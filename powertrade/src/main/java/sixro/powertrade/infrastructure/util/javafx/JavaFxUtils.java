package sixro.powertrade.infrastructure.util.javafx;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import sixro.powertrade.Application;

public class JavaFxUtils {

	private JavaFxUtils() { }

	public static Region loadFxml(String fxmlResourcePath) {
		try {
			return FXMLLoader.load(Application.class.getResource(fxmlResourcePath));
		} catch (IOException e) {
			throw new RuntimeException("Unable to load FXML '" + fxmlResourcePath + "' due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

	public static void loadFxmlInto(String fxmlResourcePath, Pane container) {
		Region content = loadFxml(fxmlResourcePath);
		replacePaneContent(container, content);
	}

	public static void replacePaneContent(Pane pane, Region content) {
		pane.getChildren().clear();
		pane.getChildren().add(content);
		content.prefWidthProperty().bind(pane.widthProperty());
		content.prefHeightProperty().bind(pane.heightProperty());
		if (pane instanceof AnchorPane) {
			AnchorPane.setTopAnchor(content, 0d);
			AnchorPane.setBottomAnchor(content, 0d);
			AnchorPane.setLeftAnchor(content, 0d);
			AnchorPane.setRightAnchor(content, 0d);
		}
	}

}
