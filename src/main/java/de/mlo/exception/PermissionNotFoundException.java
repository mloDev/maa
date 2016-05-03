package de.mlo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionNotFoundException.
 */
public class PermissionNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6975301468402274579L;

	/**
	 * Instantiates a new permission not found exception.
	 */
	public PermissionNotFoundException() {
	}

	/**
	 * Instantiates a new permission not found exception.
	 *
	 * @param message the message
	 */
	public PermissionNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new permission not found exception.
	 *
	 * @param cause the cause
	 */
	public PermissionNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new permission not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public PermissionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new permission not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public PermissionNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
