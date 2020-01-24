package adverth.main.console;

import java.io.File;
import java.util.Arrays;
import java.util.logging.LogManager;

import org.junit.Test;

public class ConsoleBasedStockScreenerTest {

	@Test
	public void srg() {
		LogManager.getLogManager().reset();
		
		Script script = new Script(new File("./src/test/resources/myscript.txt"));
		ConsoleBasedStockScreener screener = new ConsoleBasedStockScreener(script, Arrays.asList("SRG.MI"));
		screener.run();
	}

}
