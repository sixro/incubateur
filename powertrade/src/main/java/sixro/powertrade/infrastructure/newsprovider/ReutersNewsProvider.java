package sixro.powertrade.infrastructure.newsprovider;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.*;
import java.time.temporal.ChronoField;
import java.util.*;

import org.jdeferred.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.slf4j.*;

import sixro.powertrade.domain.*;

public class ReutersNewsProvider implements NewsProvider {

	private static final Logger LOG = LoggerFactory.getLogger(ReutersNewsProvider.class);

	private static final DateTimeFormatter REUTERS_DATE_FORMAT = new DateTimeFormatterBuilder()
			.appendPattern("MMM dd yyyy[ [HH][:mm][:ss][.SSS]]")
			.parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
			.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
			.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
			.toFormatter();

	private final DeferredManager dm;

	public ReutersNewsProvider(DeferredManager dm) {
		super();
		this.dm = dm;
	}

	@Override
	public Promise<List<PieceOfNews>, Throwable, Void> findNews(String stockSymbol) {
		return dm.when(() -> {
			return findNews0(stockSymbol);
		});
	}

	protected List<PieceOfNews> findNews0(String stockSymbol) throws IOException {
		LOG.info("Retrieving news about stock '{}' ...", stockSymbol);

		Document document = Jsoup.connect("http://www.reuters.com/finance/stocks/overview?symbol=" + stockSymbol).get();
		LOG.info("... finding elements of interest...");
		Elements elements = document.select(".feature");
		List<PieceOfNews> list = new ArrayList<>(elements.size());
		for (Element element : elements) {
			Elements headerElem = element.select("h2 a");
			String title = headerElem.text();
			String link = headerElem.attr("href");
			String summary = element.select("p").text();
			String datetime = element.select(".timestamp").text();
			LOG.debug("... obtained: {} ...", element);
			LOG.info("... news title: '{}' ...", title);
			LOG.info("... news link: '{}' ...", link);
			LOG.info("... news summary: '{}' ...", summary);
			LOG.info("... news datetime: '{}' ...", datetime);

			URL newsURL = new URL("http://www.reuters.com" + link);
			PieceOfNews pieceOfNews = new PieceOfNews(
				title,
				"Reuters",
				LocalDateTime.parse(datetime, REUTERS_DATE_FORMAT),
				summary,
				newsURL
			);
			LOG.info("... adding {} ...", pieceOfNews);
			list.add(pieceOfNews);
		}

		LOG.info("... returning news {} ...", list);
		return list;
	}

}
