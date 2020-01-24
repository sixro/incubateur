package sixro.powertrade.infrastructure.util.javafx;

import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

public class FXML {

	private URL location;
	private Object controller;
	private ResourceBundle resourceBundle;

	private FXML() { }

	public static FXML aFxml() {
		return new FXML();
	}

	public FXML atLocation(URL location) {
		this.location = location;
		return this;
	}

	public FXML atLocation(String locationInClasspath) {
		return atLocation(FXML.class.getResource(locationInClasspath));
	}

	public FXML withController(Object controller) {
		this.controller = controller;
		return this;
	}

	public FXML withResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		return this;
	}

	public Region load() {
		FXMLLoader loader = new FXMLLoader(location);
		if (controller != null)
			loader.setController(controller);
		if (resourceBundle != null)
			loader.setResources(resourceBundle);

		try {
			return loader.load();
		} catch (IOException e) {
			throw new RuntimeException("Unable to load FXML located at '" + location + "' due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
