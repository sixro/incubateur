package sixro.powertrade.infrastructure.financeservice;

import static java.util.Arrays.*;

import java.util.List;

import org.jdeferred.impl.DefaultDeferredManager;
import org.junit.*;

import sixro.powertrade.domain.Stock;
import testing.AbstractPromiseTest;

public class YahooLibFinanceServiceIT extends AbstractPromiseTest {

	@Test
	public void find_stocks() throws Throwable {
		YahooLibFinanceService service = new YahooLibFinanceService(new DefaultDeferredManager());
		List<Stock> list = runAndWait(service.findStocks(asList("MS.MI")));
		Assert.assertEquals(1, list.size());
		Assert.assertEquals("MEDIASET S.P.A", list.get(0).getName());
	}

}
