package lessannoyingsmtpappender;

import java.util.*;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.boolex.OnErrorEvaluator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.*;
import ch.qos.logback.core.boolex.*;

public class LessAnnoyingSMTPAppender extends AppenderBase<ILoggingEvent> {

	private final List<ILoggingEvent> cachedEvents;
	private final Scheduler scheduler;

	private Postman postman;

	private EventEvaluator<ILoggingEvent> eventEvaluator;
	private String smtpHost;
	private int smtpPort;
	private boolean ssl;
	private String username;
	private String password;
	private String from;
	private final List<String> allTo;
	private String firstEventSubject;
	private String firstEventBodyTemplate;
	
	public LessAnnoyingSMTPAppender() {
		super();
		this.cachedEvents = new LinkedList<ILoggingEvent>();
		this.scheduler = new SchedulerJavaTimer();
		this.allTo = new LinkedList<String>();
	}

	LessAnnoyingSMTPAppender(Postman postman, Scheduler scheduler) {
		super();
		this.postman = postman;
		this.scheduler = scheduler;
		this.cachedEvents = new LinkedList<ILoggingEvent>();
		this.allTo = new LinkedList<String>();
	}

	public EventEvaluator<ILoggingEvent> getEventEvaluator() {
		return eventEvaluator;
	}

	public void setEventEvaluator(EventEvaluator<ILoggingEvent> eventEvaluator) {
		this.eventEvaluator = eventEvaluator;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFirstEventSubject() {
		return firstEventSubject;
	}

	public void setFirstEventSubject(String firstEventSubject) {
		this.firstEventSubject = firstEventSubject;
	}

	public String getFirstEventBodyTemplate() {
		return firstEventBodyTemplate;
	}

	public void setFirstEventBodyTemplate(String firstEventBodyTemplate) {
		this.firstEventBodyTemplate = firstEventBodyTemplate;
	}

	public void setTo(String to) {
		this.allTo.add(to);
	}
	
	void cacheLoggingEvent(ILoggingEvent event) {
		cachedEvents.add(event);
	}
	
	int countCachedEvents() {
		return cachedEvents.size();
	}
	
	@Override
	public void start() {
		if (eventEvaluator == null)
			this.eventEvaluator = newOnErrorEvaluator(getContext());
		
		PatternLayout firstEventSubjectPatternLayout = new PatternLayout();
		firstEventSubjectPatternLayout.setContext(getContext());
		firstEventSubjectPatternLayout.setPattern(firstEventSubject);
		firstEventSubjectPatternLayout.setPostCompileProcessor(null);
		firstEventSubjectPatternLayout.start();
		this.postman = new PostmanMail(smtpHost, smtpPort, ssl, username, password, from, allTo, firstEventSubjectPatternLayout, firstEventBodyTemplate);
		
		super.start();
	}

	@Override
	protected void append(ILoggingEvent event) {
		try {
			if (! eventEvaluator.evaluate(event))
				return;
			
			appendEvaluatedEvent(event);
		}
		catch (NullPointerException ignore) { }
		catch (EvaluationException ignore) { }
	}

	protected synchronized void appendEvaluatedEvent(ILoggingEvent event) {
		cacheLoggingEvent(event);
		if (countCachedEvents() == 1)
			postman.send(event);
		else {
			scheduler.runAtTheStrokeOfTheNextHour(new TimerTask() {
				@Override
				public void run() {
					LessAnnoyingSMTPAppender.this.onNextHour();
				}
			});
		}
	}

	protected synchronized void onNextHour() {
		postman.send(cachedEvents);
		cachedEvents.clear();
	}

	private static OnErrorEvaluator newOnErrorEvaluator(Context context) {
		OnErrorEvaluator onError = new OnErrorEvaluator();
		onError.setContext(context);
		onError.setName("onError");
		onError.start();
		return onError;
	}

}
