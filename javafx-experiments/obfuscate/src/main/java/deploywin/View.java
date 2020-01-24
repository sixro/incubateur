package deploywin;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class View extends StackPane {

	public void addButton(Button btn) {
		getChildren().add(btn);
	}
}
