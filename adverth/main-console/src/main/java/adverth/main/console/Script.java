package adverth.main.console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import adverth.core.CompositeFilter;
import adverth.core.Filter;
import adverth.core.MAType;
import adverth.core.TimeFrame;
import adverth.core.filter.CrossingMA;
import adverth.core.filter.MarketCap;
import adverth.yahoo.YahooMAProvider;
import adverth.yahoo.YahooMarketCapProvider;

public class Script {

	private final File file;

	public Script(File filepath) {
		this.file = filepath;
	}

	public Filter toFilters() {
		try {
			List<Filter> filters = new LinkedList<>();
			List<String> lines = Files.readAllLines(file.toPath());
			for (String l : lines) {
				l = l.trim();
				if (l.isEmpty()) continue;
				if (l.startsWith("#")) continue; // comment
				
				Filter filter = Script.parse(l);
				filters.add(filter);
			}
			
			return new CompositeFilter(filters.toArray(new Filter[0]));
		} catch (IOException e) {
			// FIXME impl
			e.printStackTrace();
			return null;
		}
	}

	public static Filter parse(String text) {
		String[] strings = text.split("\\s");
		//System.out.println(Arrays.toString(strings));
		if (strings[0].equals("market_cap")) {
			String tmp = text.substring(strings[0].length() +1);
			String expression = tmp.substring(0, tmp.lastIndexOf("\""));
			expression = expression.substring(expression.indexOf("\"") +1);
			return new MarketCap(new YahooMarketCapProvider(), expression);
		}
		else if (strings[0].equals("crossing_ma")) {
			CrossingMA filter = new CrossingMA(
				new YahooMAProvider(), 
				TimeFrame.valueOf(strings[1]), 
				MAType.valueOf(strings[2]), Integer.parseInt(strings[3]), 
				MAType.valueOf(strings[4]), Integer.parseInt(strings[5]), 
				Integer.parseInt(strings[6])
			);
			return filter;
		}
		
		throw new IllegalArgumentException("Unable to parse \"" + text + "\" as a filter");
	}

}
