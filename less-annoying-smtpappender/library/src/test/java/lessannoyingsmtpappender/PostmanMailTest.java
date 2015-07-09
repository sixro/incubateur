package lessannoyingsmtpappender;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import ch.qos.logback.classic.spi.*;
import ch.qos.logback.core.Layout;

import com.dumbster.smtp.SimpleSmtpServer;

public class PostmanMailTest {

	private static final int SMTP_PORT = 12345;

	private SimpleSmtpServer smtpServer;
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	@SuppressWarnings("unchecked")
	private Layout<ILoggingEvent> layout = context.mock(Layout.class);
	
	@Test
	public void sendOneMail() {
		smtpServer = SimpleSmtpServer.start(SMTP_PORT);
		
		context.checking(new Expectations() {{ 
			oneOf(layout).doLayout(with(any(ILoggingEvent.class)));
		}});
		
		PostmanMail postman = new PostmanMail("localhost", SMTP_PORT, false, null, null, "me@localhost", asList("you@localhost"), layout, "");
		postman.send(new LoggingEvent());
		
		assertEquals(1, smtpServer.getReceivedEmailSize());
		smtpServer.stop();
	}

}
