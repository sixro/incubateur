package lessannoyingsmtpappender;

import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;

public interface Postman {

	void send(ILoggingEvent loggingEvent);

	void send(List<ILoggingEvent> loggingEvents);

}
