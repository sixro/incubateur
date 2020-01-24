package sixro.powertrade.infrastructure.reuters;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.*;
import java.util.Locale;
import java.util.regex.*;
import java.util.stream.Stream;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.slf4j.*;

import sixro.powertrade.domain.MarketIndex;

public class Reuters {

	private static final Logger LOG = LoggerFactory.getLogger(Reuters.class);

	private static final Pattern MARKET_INDEX_NAME_REGEX = Pattern.compile("^Index Detail: (.*)$");

	private static final int CONNECT_TIMEOUT = Integer.getInteger("powertrade.reuters.connection.timeoutInSeconds", 3) * 1000;

	public Reuters() {
		super();
	}

	public Stream<String> symbols() {
		try {
			Connection connect = connectTo("http://www.reuters.com/finance/markets/index");
			Document document = connect.get();
			return document.select(".marketSelectDropdown .simpleControls select option")
					.stream()
					.map(el -> el.attr("value"))
					.filter(s -> !s.equals("-1"));
		} catch (IOException e) {
			throw new RuntimeException("Unable to retrieve market indices symbols due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

	public MarketIndex marketIndex(String symbol) {
		try {
			Connection connect = connectTo("http://www.reuters.com/finance/markets/index?symbol=" + symbol);
			Document document = connect.get();
			return toMarketIndex(symbol, document);
		} catch (IOException e) {
			throw new RuntimeException("Unable to retrieve market index " + symbol + " due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

	private Connection connectTo(String url) {
		return Jsoup.connect(url)
				.timeout(CONNECT_TIMEOUT);
	}

	static MarketIndex toMarketIndex(String symbol, Document document) {
		String name = parseName(document);

		String text = document
			.select("#headerQuoteContainer .sectionQuote .label:contains(Price)")
			.first()
			.parent()
			.select(".dataHeader")
			.text();
		LOG.info("[toMarketIndex] lastPrice: {}", text);
		BigDecimal lastPrice = BigDecimalParser.parse(text);

		text = document
			.select("#headerQuoteContainer .sectionQuote .label:contains(Today's Change)")
			.first()
			.parent()
			.select(".dataParenthetical")
			.text();
		text = text.substring(0, text.length() -2);
		text = text.substring(1);
		BigDecimal percVariation = BigDecimalParser.parse(text);

		text = document.select(".indexInfo .dataTable .label:matches(.*Day's Low.*)")
			.last()
			.parent()
			.select(".data")
			.text();
		LOG.info("[toMarketIndex] min: {}", text);
		BigDecimal min = BigDecimalParser.parse(text);

		text = document.select(".indexInfo .dataTable .label:matches(.*Day's Low.*)")
			.first()
			.parent()
			.select(".data")
			.text();
		LOG.info("[toMarketIndex] min: {}", text);
		BigDecimal max = BigDecimalParser.parse(text);

		return new MarketIndex(symbol, name,
			lastPrice, percVariation, null /* volume not available */,
			min, max
		);
	}

	private static String parseName(Document document) {
		Matcher matcher = MARKET_INDEX_NAME_REGEX.matcher(document.select("h1").text());
		return matcher.matches() ? matcher.group(1) : null;
	}


	public static class BigDecimalParser {

		private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.0###", DecimalFormatSymbols.getInstance(Locale.US));
		static {
			DECIMAL_FORMAT.setParseBigDecimal(true);
		}

		public static BigDecimal parse(String text) {
			if (text.equals("--"))
				return null;
			
			try {
				return (BigDecimal) DECIMAL_FORMAT.parse(text);
			} catch (ParseException e) {
				throw new RuntimeException("Unable to parse '" + text + "' as number", e);
			}
		}

	}

}
