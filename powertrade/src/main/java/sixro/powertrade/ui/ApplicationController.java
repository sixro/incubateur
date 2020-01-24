package sixro.powertrade.ui;

import static sixro.powertrade.infrastructure.util.javafx.FXML.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import sixro.powertrade.infrastructure.util.javafx.JavaFxUtils;

public class ApplicationController implements Initializable {

	@FXML private Label lblLogo;
	@FXML private ToggleButton btnPrefs;
	@FXML private ToggleButton btnHelp;
	@FXML private HBox tickersPane;
	@FXML private AnchorPane contentPane;

	private final MainController mainController;

	public ApplicationController(MainController mainController) {
		super();
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Region mainPane = aFxml()
			.atLocation("/main.fxml")
			.withController(mainController)
			.load();
		Region prefsPane = aFxml()
			.atLocation("/prefs.fxml")
			.load();
		Region helpPane = aFxml()
			.atLocation("/help.fxml")
			.load();
		JavaFxUtils.replacePaneContent(contentPane, mainPane);

		btnPrefs.selectedProperty().addListener((a, b, selected) -> {
			if (! selected) {
				JavaFxUtils.replacePaneContent(contentPane, mainPane);
			} else {
				if (btnHelp.isSelected())
					btnHelp.setSelected(false);
				JavaFxUtils.replacePaneContent(contentPane, prefsPane);
			}
		});
		btnHelp.selectedProperty().addListener((a, b, selected) -> {
			if (! selected) {
				JavaFxUtils.replacePaneContent(contentPane, mainPane);
			} else {
				if (btnPrefs.isSelected())
					btnPrefs.setSelected(false);
				JavaFxUtils.replacePaneContent(contentPane, helpPane);
			}
		});
	}

}
