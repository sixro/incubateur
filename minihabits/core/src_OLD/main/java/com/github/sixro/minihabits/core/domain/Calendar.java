package com.github.sixro.minihabits.core.domain;

import java.util.Date;

/**
 * Represents an abstraction of a Calendar. This is not the java Calendar object, but a domain abstraction.
 */
public interface Calendar {

	Date yesterday();

	Date today();

	Date toDateAtMidnight(String iso8601Text);

	Date toDateAtMidnight(Date date);

	String formatAsDateAtMidnight(Date date);

}
