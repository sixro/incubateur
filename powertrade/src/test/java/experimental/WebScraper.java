package experimental;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebScraper
{
  private static final Logger LOG = LoggerFactory.getLogger(WebScraper.class);

  private final String pageUrl;
  private final Map<String, String> selectorsByDatum;
  private final Map<String, WebScraper.ArraySelector> arraySelectorsByDatum;

  private WebScraper(String pageUrl) {
    this.pageUrl = pageUrl;
    this.selectorsByDatum = new ConcurrentHashMap<>();
    this.arraySelectorsByDatum = new ConcurrentHashMap<>();
  }

  public static WebScraper on(String pageUrl)
  {
    return new WebScraper(pageUrl);
  }

  public WebScraper find(String datum, String selector)
  {
    selectorsByDatum.put(datum, selector);
    return this;
  }

  public WebScraper findInArray(String datum, String selector, int index)
  {
    arraySelectorsByDatum.put(datum, new ArraySelector(selector, index));
    return this;
  }

  public Map<String, Object> scrape()
  {
    long start = System.currentTimeMillis();
    LOG.info("Scraping page '{}' ...", pageUrl);

    try
    {
      Connection connection = Jsoup.connect(pageUrl);
      Document document = connection.get();

      Map<String, Object> data = new ConcurrentHashMap<>();
      for (Map.Entry<String, String> entry: selectorsByDatum.entrySet()) {
        String datum = entry.getKey();
        String selector = entry.getValue();
        LOG.debug("... selecting '{}' using selector '{}' ...", datum, selector);
        Elements elements = document.select(selector);
        LOG.debug("... elements: {}, html: {}", elements.size(), elements.html());
        String text = elements.text();
        LOG.debug("text: {}", text);
        data.put(datum, text);
      }
      for (Map.Entry<String, ArraySelector> entry: arraySelectorsByDatum.entrySet()) {
        String datum = entry.getKey();
        ArraySelector arraySelector = entry.getValue();
        LOG.debug("... selecting '{}' using selector '{}' ...", datum, arraySelector.selector);
        Element element = document.select(arraySelector.selector).get(arraySelector.index);
        LOG.debug("... html: {}", element.html());
        String text = element.text();
        LOG.debug("text: {}", text);
        data.put(datum, text);
      }

      LOG.info("... page '{}' scraped, returning data: {} (elapsed: {} ms)", pageUrl, data, System.currentTimeMillis() -start);
      return data;
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private static class ArraySelector
  {
    public final String selector;
    public final int index;

    public ArraySelector(String selector, int index)
    {
      this.selector = selector;
      this.index = index;
    }
  }
}
