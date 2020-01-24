package com.github.sixro.minihabits.core.domain;

public class LastFeedbackDateUnavailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public LastFeedbackDateUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public LastFeedbackDateUnavailableException(String message) {
		super(message);
	}

	public LastFeedbackDateUnavailableException(Throwable cause) {
		super(cause);
	}

}
