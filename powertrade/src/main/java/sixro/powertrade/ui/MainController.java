package sixro.powertrade.ui;

import static sixro.powertrade.infrastructure.util.javafx.FXML.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import sixro.powertrade.infrastructure.util.javafx.JavaFxUtils;
import sixro.powertrade.ui.main.*;

public class MainController implements Initializable {

    @FXML private HBox tickersPane;
    @FXML private SplitPane centralPaneContainer;

    @FXML private Tab watchlistsPane;
    @FXML private AnchorPane watchlistsPaneContainer;

    @FXML private Tab portfolioPane;

    @FXML private Tab newsPane;
    @FXML private AnchorPane newsContainer;
    @FXML private Tab indicesPane;
    @FXML private AnchorPane indicesContainer;
    @FXML private Tab spreadPane;

    @FXML private Tab alertPane;
    @FXML private Tab ordersPane;

    private final MainWatchlistsController mainWatchlistsController;
    private final MainNewsController mainNewsController;
    private final MainIndicesController mainIndicesController;

    private double previousCentralPaneContainerDividerPosition = -1d;

	public MainController(MainWatchlistsController mainWatchlistsController, MainNewsController mainNewsController,
			MainIndicesController mainIndicesController) {
		super();
		this.mainWatchlistsController = mainWatchlistsController;
		this.mainNewsController = mainNewsController;
		this.mainIndicesController = mainIndicesController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainWatchlistsController.addShowChartButtonSelectedListener((observable, oldvalue, newvalue) -> {
			if (!newvalue) {
				previousCentralPaneContainerDividerPosition = centralPaneContainer.getDividerPositions()[0];
				centralPaneContainer.setDividerPosition(0, 1.0d);
			} else {
				centralPaneContainer.setDividerPosition(0, previousCentralPaneContainerDividerPosition);
			}
		});
		Region mainWatchlists = aFxml()
			.atLocation("/mainWatchlists.fxml")
			.withController(mainWatchlistsController)
			.load();
		JavaFxUtils.replacePaneContent(watchlistsPaneContainer, mainWatchlists);

		Region mainNews = aFxml()
				.atLocation("/mainNews.fxml")
				.withController(mainNewsController)
				.load();
		JavaFxUtils.replacePaneContent(newsContainer, mainNews);
		Region mainIndices = aFxml()
				.atLocation("/mainIndices.fxml")
				.withController(mainIndicesController)
				.load();
		JavaFxUtils.replacePaneContent(indicesContainer, mainIndices);
	}

}
