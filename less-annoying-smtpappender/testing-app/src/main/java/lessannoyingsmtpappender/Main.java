package lessannoyingsmtpappender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	public static void main(String... args) throws InterruptedException {
		LOG.debug("This is a DEBUG message...");
		LOG.trace("This is a TRACE message...");
		LOG.info("This is an INFO message...");
		Exception e = new IllegalStateException("NO PANIC! This is not for real!");
		LOG.warn("This is a WARN message due to a {} with message '{}'", e.getClass().getName(), e.getMessage(), e);
		LOG.error("This is a ERROR message due to a {} with message '{}'", e.getClass().getName(), e.getMessage(), e);
		LOG.error("This is another one ERROR message due to a {} with message '{}'", e.getClass().getName(), e.getMessage(), e);
		
		Thread.sleep(3 * 1000);
	}
	
}
