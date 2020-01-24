package experimental;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WebScraperIT
{

  @Test public void empty_data() {
    Map<String, Object> data = WebScraper
      .on("http://www.reuters.com/finance/stocks/overview?symbol=MS.MI")
      .scrape();
    assertTrue(data.isEmpty());
  }

  @Test public void returns_data() {
    Map<String, Object> data = WebScraper
      .on("http://www.reuters.com/finance/stocks/overview?symbol=MS.MI")
      .find("name", "#sectionTitle h1")
      .findInArray("lastPrice", "#headerQuoteContainer .sectionQuote:eq(0) span", 1)
      .scrape();

    assertThat(data, Matchers.hasEntry("name", "Mediaset SpA (MS.MI)"));
    assertThat(data, Matchers.hasEntry("lastPrice", "2.61"));
  }

  @Test public void find_all() {
    Map<String, Object> data = WebScraper
      .on("http://www.reuters.com/finance/stocks/overview?symbol=MS.MI")
      .find("name", "#sectionTitle h1")
      .findInArray("lastPrice", "#headerQuoteContainer .sectionQuote:eq(0) span", 1)
      .scrape();

    assertThat(data, Matchers.hasEntry("name", "Mediaset SpA (MS.MI)"));
    assertThat(data, Matchers.hasEntry("lastPrice", "2.61"));
  }

}