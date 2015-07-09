package lessannoyingsmtpappender;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.TimerTask;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;

public class LessAnnoyingSMTPAppenderTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	@SuppressWarnings("unchecked")
	private EventEvaluator<ILoggingEvent> eventEvaluator = context.mock(EventEvaluator.class);
	private Scheduler scheduler = context.mock(Scheduler.class);
	private Postman postman = context.mock(Postman.class);
	private LessAnnoyingSMTPAppender appender;
	
	@Before public void setup() {
		appender = new LessAnnoyingSMTPAppender(postman, scheduler);
		appender.setEventEvaluator(eventEvaluator);
	}
	
	@Test public void doesNothingWhenEventIsEvaluatedNegatively() throws EvaluationException {
		final ILoggingEvent event = new LoggingEvent();
		
		context.checking(new Expectations() {{ 
			oneOf(eventEvaluator).evaluate(event);
				will(returnValue(false));
		}});
		
		appender.append(event);
	}
	
	@Test public void doesNothingOnNullPointerExceptionByEventEvaluator() throws EvaluationException {
		final ILoggingEvent event = new LoggingEvent();
		
		context.checking(new Expectations() {{ 
			oneOf(eventEvaluator).evaluate(event);
				will(throwException(new NullPointerException("This is a test")));
		}});
		
		appender.append(event);
	}
	
	@Test public void doesNothingOnEvaluationException() throws EvaluationException {
		final ILoggingEvent event = new LoggingEvent();
		
		context.checking(new Expectations() {{ 
			oneOf(eventEvaluator).evaluate(event);
				will(throwException(new EvaluationException("This is a test")));
		}});
		
		appender.append(event);
	}

	@Test public void notifyTheFirstEventOccured() {
		final ILoggingEvent event = new LoggingEvent();
		
		context.checking(new Expectations() {{ 
			oneOf(postman).send(event);
		}});
		
		appender.appendEvaluatedEvent(event);
	}

	@Test public void nextEventIsScheduledForNextHourTogetherWithPreviousOne() {
		final ILoggingEvent event1 = new LoggingEvent();
		final ILoggingEvent event2 = new LoggingEvent();
		
		context.checking(new Expectations() {{ 
			oneOf(postman).send(event1);
			
			oneOf(scheduler).runAtTheStrokeOfTheNextHour(with(any(TimerTask.class)));
		}});
		
		appender.appendEvaluatedEvent(event1);
		appender.appendEvaluatedEvent(event2);
		assertEquals(2, appender.countCachedEvents());
	}
	
	@Test public void onNextHourSendAllCachedLoggingEventsAndClearIt() {
		final ILoggingEvent event1 = new LoggingEvent();
		final ILoggingEvent event2 = new LoggingEvent();
		appender.cacheLoggingEvent(event1);
		appender.cacheLoggingEvent(event2);
		
		context.checking(new Expectations() {{ 
			oneOf(postman).send(asList(event1, event2));
		}});
		
		appender.onNextHour();
		assertEquals(0, appender.countCachedEvents());
	}

}
