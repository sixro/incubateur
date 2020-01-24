package sixro.powertrade;

import java.util.concurrent.*;

import org.jdeferred.DeferredManager;
import org.jdeferred.impl.DefaultDeferredManager;
import org.slf4j.*;

import com.google.common.eventbus.*;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sixro.powertrade.domain.*;
import sixro.powertrade.infrastructure.financeservice.*;
import sixro.powertrade.infrastructure.newsprovider.ReutersNewsProvider;
import sixro.powertrade.infrastructure.repository.InMemoryRepository;
import sixro.powertrade.infrastructure.util.javafx.FXML;
import sixro.powertrade.ui.*;
import sixro.powertrade.ui.main.*;

// TODO rivedere l'operazione di caricamento stocks da watchlist (evitare il proliferare dei promise e agg. error handler)
// TODO probabilmente e' meglio introdurre il concetto di Price (max 4 digits... int?)
// TODO load bond spread
// TODO an order can be created on a selected stock
// TODO when an order is "executed" the stock is added to portfolio
// TODO create a "representation" of the portfolio
// TODO refine watchlist "representation"
// TODO refine portfolio "representation"
// TODO watchlists e portfolio hanno colonne visualizzate differenti in base alla visualizzazione o meno del chart

// TODO add alert on a selected stock
// TODO when alert fire the related order is added

// NICE2HAVE on news: 2click => open a browser with the link; some button to clear the filter
public class Application extends javafx.application.Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	private ExecutorService executorService;

	public static void main(String... args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		LOG.info("Starting application...");

		executorService = Executors.newCachedThreadPool();

		EventBus eventBus = new AsyncEventBus(executorService);
		eventBus.register(this);

		DeferredManager dm = new DefaultDeferredManager(executorService);

		// Initialize common domain objects...
		Repository repository = new InMemoryRepository();
		NewsProvider newsProvider = new ReutersNewsProvider(dm);
		FinanceService financeService = new YahooLibFinanceService(dm);

		// Initialize controllers...
		MainWatchlistsController mainWatchlistsController = new MainWatchlistsController(eventBus, repository, financeService);
		MainNewsController mainNewsController = new MainNewsController(newsProvider, eventBus);
		MarketIndexProvider marketIndexProvider = new ReutersMarketIndexProvider(dm);
		MainIndicesController mainIndicesController = new MainIndicesController(dm, eventBus, marketIndexProvider);
		MainController mainController = new MainController(mainWatchlistsController, mainNewsController, mainIndicesController);

		ApplicationController controller = new ApplicationController(mainController);
		Region root = FXML.aFxml()
			.atLocation("/application.fxml")
			.withController(controller)
			.load();

		Scene scene = new Scene(root, 800, 600);

		stage.setTitle("POWERTRADE");
		stage.setScene(scene);
		stage.show();

		LOG.info("... application started");
	}

	@Override
	public void stop() throws Exception {
		executorService.shutdown();
		super.stop();
	}

}
