package de.mlo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupeNotFoundException.
 */
public class GroupeNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1402337502045439388L;

	/**
	 * Instantiates a new groupe not found exception.
	 */
	public GroupeNotFoundException() {
	}

	/**
	 * Instantiates a new groupe not found exception.
	 *
	 * @param message the message
	 */
	public GroupeNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new groupe not found exception.
	 *
	 * @param cause the cause
	 */
	public GroupeNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new groupe not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GroupeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new groupe not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public GroupeNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
