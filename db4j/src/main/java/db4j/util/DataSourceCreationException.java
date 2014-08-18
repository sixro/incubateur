package db4j.util;

import javax.sql.DataSource;

/**
 * Represents an exception thrown when there is an error trying
 * to create a {@link DataSource}.
 */
public class DataSourceCreationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataSourceCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataSourceCreationException(String message) {
		super(message);
	}

	public DataSourceCreationException(Throwable cause) {
		super(cause);
	}
	
}
