package sixro.powertrade.ui.main;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.*;

import com.google.common.eventbus.*;

import javafx.application.Platform;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sixro.powertrade.domain.*;
import sixro.powertrade.infrastructure.util.javafx.*;
import sixro.powertrade.ui.StockSelectedEvent;

public class MainNewsController implements Initializable {

	private static final Logger LOG = LoggerFactory.getLogger(MainNewsController.class);

    @FXML private TextField tfFilter;
    @FXML private TableView<PieceOfNews> tblNews;
    @FXML private TableColumn<PieceOfNews, String> tcTime;
    @FXML private TableColumn<PieceOfNews, String> tcSummary;

    private final NewsProvider newsProvider;
    private final EventBus eventBus;

    private ObservableList<PieceOfNews> olNews;
    private FilteredList<PieceOfNews> flNews;

	public MainNewsController(NewsProvider newsProvider, EventBus eventBus) {
		super();
		this.newsProvider = newsProvider;
		this.eventBus = eventBus;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		eventBus.register(this);

		// TODO Create an utils in JavaFxUtils
		tblNews.setRowFactory(c -> new TableRow<PieceOfNews>() {
			private Tooltip tooltip;

			{
				tooltip = new Tooltip();
				tooltip.setWrapText(true);
				tooltip.setPrefWidth(300d);
			}

			@Override
			protected void updateItem(PieceOfNews item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null) {
					setTooltip(null);
				} else {
					tooltip.setText(item.getSource() + "\n" + item.getSummary() + "\n" + item.getLink());
					setTooltip(tooltip);
				}
			}
		});
		tcTime.setCellValueFactory(new DateTimeReflectionedPropertyValueFactory<PieceOfNews, LocalDateTime>("datetime", DateTimeFormatter.ofPattern("MMM dd yyyy")));
		tcSummary.setCellValueFactory(new ReflectionedPropertyValueFactory<PieceOfNews, String>("summary"));

		olNews = FXCollections.observableArrayList(new ArrayList<PieceOfNews>());
		flNews = new FilteredList<>(olNews, p -> true);
		tblNews.setItems(flNews);

		tfFilter.textProperty().addListener((observable, oldvalue, newvalue) -> {
			flNews.setPredicate(pieceOfNews -> {
				if (StringUtils.isBlank(newvalue))
					return true;

				return pieceOfNews.getSummary().toLowerCase().contains(newvalue.toLowerCase());
			});
		});
	}

	@Subscribe public void onStockSelected(StockSelectedEvent event) {
		LOG.debug("event: {}", event);

		JavaFxPromiseDecorator.on(newsProvider.findNews(event.getStockSymbol()))
			.withBlockUI()
			.withErrorHandler()
			.decorate()
			.done(list -> {
				Platform.runLater(()-> { olNews.setAll(list); });
			});
	}

}
