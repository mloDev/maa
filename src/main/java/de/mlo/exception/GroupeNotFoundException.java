package de.mlo.exception;

public class GroupeNotFoundException extends Exception {

	private static final long serialVersionUID = -1402337502045439388L;

	public GroupeNotFoundException() {
	}

	public GroupeNotFoundException(String message) {
		super(message);
	}

	public GroupeNotFoundException(Throwable cause) {
		super(cause);
	}

	public GroupeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public GroupeNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
