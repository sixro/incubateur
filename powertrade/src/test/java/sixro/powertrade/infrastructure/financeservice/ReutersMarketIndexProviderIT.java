package sixro.powertrade.infrastructure.financeservice;

import org.jdeferred.impl.DefaultDeferredManager;
import org.junit.*;

public class ReutersMarketIndexProviderIT {

	private ReutersMarketIndexProvider provider = new ReutersMarketIndexProvider(new DefaultDeferredManager());

	@Test
	public void find_market_indices() throws InterruptedException {
		long start = System.currentTimeMillis();
		provider.findAll()
			.done(l -> {
				System.out.println("elapsed: " + (System.currentTimeMillis() -start) + "ms");
				Assert.assertTrue(l.size() > 0);
			})
			.progress(v -> System.out.println(v))
			.waitSafely();
			;
	}

}
