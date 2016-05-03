package de.mlo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicateUserException.
 */
public class DuplicateUserException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6532938055712085137L;

	/**
	 * Instantiates a new duplicate user exception.
	 */
	public DuplicateUserException() {
	}

	/**
	 * Instantiates a new duplicate user exception.
	 *
	 * @param arg0 the arg0
	 */
	public DuplicateUserException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new duplicate user exception.
	 *
	 * @param arg0 the arg0
	 */
	public DuplicateUserException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new duplicate user exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public DuplicateUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new duplicate user exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @param arg2 the arg2
	 * @param arg3 the arg3
	 */
	public DuplicateUserException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
