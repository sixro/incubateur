package sixro.powertrade.ui.main;

import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

import org.slf4j.*;

import com.google.common.eventbus.EventBus;

import javafx.beans.value.ChangeListener;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sixro.powertrade.domain.*;
import sixro.powertrade.infrastructure.util.javafx.*;
import sixro.powertrade.ui.StockSelectedEvent;

public class MainWatchlistsController implements Initializable {

	private static final Logger LOG = LoggerFactory.getLogger(MainWatchlistsController.class);

    @FXML private ComboBox<String> cboWatchlists;
    @FXML private Button btnEditWatchLists;
    @FXML private ToggleButton btnShowChart;
    @FXML private TableView<Stock> tableStocksInSelWatchlist;
    @FXML private TableColumn<Stock, String> tcSymbol;
    @FXML private TableColumn<Stock, String> tcName;
    @FXML private TableColumn<Stock, BigDecimal> tcLast;
    @FXML private TableColumn<Stock, BigDecimal> tcVar;
    @FXML private TableColumn<Stock, BigDecimal> tcVolume;
    @FXML private TableColumn<Stock, BigDecimal> tcBidQuantity;
    @FXML private TableColumn<Stock, BigDecimal> tcBid;
    @FXML private TableColumn<Stock, BigDecimal> tcAsk;
    @FXML private TableColumn<Stock, BigDecimal> tcAskQuantity;

    private final EventBus eventBus;
    private final Repository repository;
    private final FinanceService financeService;
    private List<ChangeListener<Boolean>> showChartButtonListeners;

	private ObservableList<String> watchlists;
	private ObservableList<Stock> stocksInSelectedWatchlist;

	public MainWatchlistsController(EventBus eventBus, Repository repository, FinanceService financeService) {
		super();
		this.eventBus = eventBus;
		this.repository = repository;
		this.financeService = financeService;

		this.showChartButtonListeners = new LinkedList<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stocksInSelectedWatchlist = FXCollections.observableList(new ArrayList<>());
		watchlists = FXCollections.observableArrayList(repository.findAllWatchlists());

		cboWatchlists.setItems(watchlists);
		cboWatchlists.valueProperty().addListener((observable, oldvalue, newvalue) -> {
			List<String> stockSymbols = repository.findStockSymbols(newvalue);

			JavaFxPromiseDecorator.on(financeService.findStocks(stockSymbols))
				.withBlockUI()
				.withErrorHandler()
				.decorate()
				.done(list -> stocksInSelectedWatchlist.setAll(list));
		});

		tableStocksInSelWatchlist.setItems(stocksInSelectedWatchlist);
		tcSymbol.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, String>("symbol"));
		tcName.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, String>("name"));
		tcLast.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastPriceInfo.price"));
		tcVar.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastPriceInfo.variation"));
		tcVolume.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastPriceInfo.volume"));
		tcBidQuantity.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastBook.bidQuantity"));
		tcBid.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastBook.bid"));
		tcAskQuantity.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastBook.askQuantity"));
		tcAsk.setCellValueFactory(new ReflectionedPropertyValueFactory<Stock, BigDecimal>("lastBook.ask"));
		tableStocksInSelWatchlist.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
			LOG.info("Selected item in watchlist: {} ...", newSelection);
			Stock item = (Stock) newSelection;
			eventBus.post(new StockSelectedEvent(this, item.getSymbol()));
		});

		btnShowChart.setSelected(true);

		for (ChangeListener<Boolean> changeListener : showChartButtonListeners)
			btnShowChart.selectedProperty().addListener(changeListener);
	}

	public void addShowChartButtonSelectedListener(ChangeListener<Boolean> listener) {
		showChartButtonListeners.add(listener);
	}

}
