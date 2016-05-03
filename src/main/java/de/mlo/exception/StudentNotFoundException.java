package de.mlo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentNotFoundException.
 */
public class StudentNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5271289705048067030L;
	
    /**
     * Instantiates a new student not found exception.
     */
    public StudentNotFoundException() {
    }

    /**
     * Instantiates a new student not found exception.
     *
     * @param message the message
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

	/**
	 * Instantiates a new student not found exception.
	 *
	 * @param cause the cause
	 */
	public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new student not found exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new student not found exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public StudentNotFoundException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
