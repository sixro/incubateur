package adverth.main.console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import adverth.core.Filter;
import adverth.core.Outcome;
import adverth.core.StockScreener;

public class ConsoleBasedStockScreener {

	private final Script script;
	private final List<String> tickers;
	
	public ConsoleBasedStockScreener(Script script, String ticker) {
		super();
		this.script = script;
		this.tickers = Arrays.asList(ticker);
	}

	public ConsoleBasedStockScreener(Script script, List<String> tickers) {
		super();
		this.script = script;
		this.tickers = tickers;
	}

	public void run() {
		StockScreener screener = new StockScreener();
		Filter filter = script.toFilters();
		for (String ticker : tickers) {
			try {
				Outcome outcome = screener.screen(ticker, filter);
				System.out.println(ticker + " " + outcome);
			} catch (Exception e) {
				System.err.println(ticker + " error: " + e.getMessage());
				e.printStackTrace(System.err);
			}
		}
	}
	
	public static void main(String... args) {
		LogManager.getLogManager().reset();
		
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption(
			Option.builder("s")
				.required()
				.longOpt("script")
				.desc("Path of the script containing filters to use to screen")
				.hasArg()
				.build()
		);
		try {
			CommandLine commandLine = parser.parse(options, args);
			String scriptPath = commandLine.getOptionValue("s");
			List<String> argList = commandLine.getArgList();
			Script script = new Script(new File(scriptPath));
			
			String tickerOrFileOfTickers = argList.get(0);
			if (! tickerOrFileOfTickers.startsWith("@")) {
				ConsoleBasedStockScreener screener = new ConsoleBasedStockScreener(script, tickerOrFileOfTickers);
				screener.run();
			} else {
				String fileOfTickers = tickerOrFileOfTickers.substring(1);
				try {
					List<String> rawTickers = Files.readAllLines(new File(fileOfTickers).toPath());
					List<String> tickers = new ArrayList<>(rawTickers.size());
					for (String ticker : rawTickers)
						tickers.add(ticker);
					ConsoleBasedStockScreener screener = new ConsoleBasedStockScreener(script, tickers);
					screener.run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// FIXME
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
