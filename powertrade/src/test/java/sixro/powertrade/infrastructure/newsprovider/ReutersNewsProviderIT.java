package sixro.powertrade.infrastructure.newsprovider;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.jdeferred.impl.DefaultDeferredManager;
import org.junit.Test;

import sixro.powertrade.domain.PieceOfNews;

public class ReutersNewsProviderIT {

	@Test
	public void returns_a_bunch_of_news() throws IOException {
		ReutersNewsProvider reuters = new ReutersNewsProvider(new DefaultDeferredManager());
		List<PieceOfNews> list = reuters.findNews0("MS.MI");
		assertTrue(list.size() > 0);
	}

}
