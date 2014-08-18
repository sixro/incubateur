package db4j;

/**
 * Represents an exception thrown using a DB.
 */
public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

}
