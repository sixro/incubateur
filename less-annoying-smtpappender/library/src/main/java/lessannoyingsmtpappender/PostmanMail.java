package lessannoyingsmtpappender;

import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.lang3.StringEscapeUtils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;

import com.github.mustachejava.*;

public class PostmanMail implements Postman {

	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	private final String smtpHost;
	private final int smtpPort;
	private final boolean ssl;
	private final String username;
	private final String password;
	private final String from;
	private final List<String> allTo;
	private final Layout<ILoggingEvent> firstEventSubjectPatternLayout;
	private final String firstEventBodyTemplate;

	public PostmanMail(String smtpHost, int smtpPort, boolean ssl, String username, String password, String from, List<String> allTo, Layout<ILoggingEvent> firstEventSubjectPatternLayout, String firstEventBodyTemplate) {
		super();
		if (allTo == null || allTo.isEmpty())
			throw new IllegalArgumentException("'at least one 'to' recipient is to be defined");
		
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.ssl = ssl;
		this.username = username;
		this.password = password;
		this.from = from;
		this.allTo = allTo;
		this.firstEventSubjectPatternLayout = firstEventSubjectPatternLayout;
		this.firstEventBodyTemplate = firstEventBodyTemplate;
	}

	@Override
	public void send(ILoggingEvent event) {
		Session session = initSession();
		
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			for (String to : allTo)
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject(firstEventSubjectPatternLayout.doLayout(event));
			
			String logRow = "<span style=\"display: block; width: 20px; background-color: red; color: white; font-weight: bold;\">&nbsp;E&nbsp;</span> " + event.getFormattedMessage() + "<br/>";
			Map<String, Object> scopes = new HashMap<String, Object>();
			scopes.put("logRow", logRow);

			MustacheFactory mustacheFactory = new DefaultMustacheFactory();
			Mustache mustache = mustacheFactory.compile(new StringReader(firstEventBodyTemplate), "postmanMail-single");
			StringWriter writer = new StringWriter();
			mustache.execute(writer, scopes);
			writer.flush();
			
			String text = StringEscapeUtils.unescapeHtml4(writer.toString());
			System.out.println("text: " + text);
			message.setContent(text, "text/html; charset=utf-8");
			
			Transport.send(message);
			System.err.println("Sent message successfully....");
		} catch (AddressException e) {
			throw new RuntimeException("unexpected behavior", e);
		} catch (MessagingException e) {
			throw new RuntimeException("unexpected behavior", e);
		}
	}

	private Session initSession() {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", smtpHost);
		properties.setProperty("mail.smtp.port", Integer.toString(smtpPort));
		if (ssl) {
			System.err.println("*** USING SSL!");
			
	        properties.put("mail.smtp.socketFactory.port", Integer.toString(smtpPort));
	        properties.put("mail.smtp.socketFactory.class", SSL_FACTORY);
	        properties.put("mail.smtp.socketFactory.fallback", "true");
		}
		Authenticator authenticator = null;
		if (username != null) {
			System.err.println("*** USING AUTH: " + username + "/" + password);
			authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};
			properties.put("mail.smtp.auth", "true");
		}
		Session session = Session.getInstance(properties, authenticator);
		session.setDebug(true);
		return session;
	}

	@Override
	public void send(List<ILoggingEvent> events) {
		// FIXME rsimoni asap
		for (ILoggingEvent event : events) {
			send(event);
		}
	}

}
