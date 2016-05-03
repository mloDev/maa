package de.mlo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends Exception {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2663040220470909688L;

    /**
     * Instantiates a new user not found exception.
     */
    public UserNotFoundException() {
    }

    /**
     * Instantiates a new user not found exception.
     *
     * @param message the message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param cause the cause
	 */
	public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new user not found exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new user not found exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UserNotFoundException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
