package sixro.powertrade.ui.main;

import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

import org.jdeferred.*;
import org.slf4j.*;

import com.google.common.eventbus.EventBus;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sixro.powertrade.domain.*;
import sixro.powertrade.infrastructure.util.javafx.*;

public class MainIndicesController implements Initializable {

	private static final Logger LOG = LoggerFactory.getLogger(MainIndicesController.class);

	@FXML private TableView<MarketIndex> tblMarketIndices;
    @FXML private TableColumn<MarketIndex, String> tcSymbol;
    @FXML private TableColumn<MarketIndex, String> tcName;
    @FXML private TableColumn<MarketIndex, BigDecimal> tcLast;
    @FXML private TableColumn<MarketIndex, BigDecimal> tcVar;
    @FXML private TableColumn<MarketIndex, BigDecimal> tcMin;
    @FXML private TableColumn<MarketIndex, BigDecimal> tcMax;

    private final DeferredManager dm;
    private final EventBus eventBus;
	private final MarketIndexProvider marketIndexProvider;
	private final ObservableList<MarketIndex> observableMarketIndices;

	public MainIndicesController(DeferredManager dm, EventBus eventBus, MarketIndexProvider marketIndexProvider) {
		this(
			dm,
			eventBus,
			marketIndexProvider,
			FXCollections.observableArrayList()
		);
	}

	public MainIndicesController(DeferredManager dm, EventBus eventBus, MarketIndexProvider marketIndexProvider, ObservableList<MarketIndex> observableMarketIndices) {
		super();
		this.dm = dm;
		this.eventBus = eventBus;
		this.marketIndexProvider = marketIndexProvider;
		this.observableMarketIndices = observableMarketIndices;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOG.info("Initializing {} ...", getClass().getName());

		tblMarketIndices.setItems(observableMarketIndices);
		tcSymbol.setCellValueFactory(new ReflectionedPropertyValueFactory<>("symbol"));
		tcName.setCellValueFactory(new ReflectionedPropertyValueFactory<>("name"));
		tcLast.setCellValueFactory(new ReflectionedPropertyValueFactory<>("lastPrice"));
		tcVar.setCellValueFactory(new ReflectionedPropertyValueFactory<>("percVariation"));
		tcMin.setCellValueFactory(new ReflectionedPropertyValueFactory<>("min"));
		tcMax.setCellValueFactory(new ReflectionedPropertyValueFactory<>("max"));

		showMarketIndices();
	}

	public void showMarketIndices() {
		Promise<List<MarketIndex>, Throwable, Double> findMarketIndices = marketIndexProvider.findAll();
		JavaFxPromiseDecorator.on(findMarketIndices)
			.withBlockUI()
			.withErrorHandler()
			.decorate()
			.done(list -> {
				LOG.info("Market indices: {}", list);
				observableMarketIndices.setAll(list);
			});
	}

}
