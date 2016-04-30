package de.mlo.exception;

public class DuplicateGroupeException extends Exception {
	private static final long serialVersionUID = 4867645708199153376L;

	public DuplicateGroupeException() {
	}

	public DuplicateGroupeException(String arg0) {
		super(arg0);
	}

	public DuplicateGroupeException(Throwable arg0) {
		super(arg0);
	}

	public DuplicateGroupeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DuplicateGroupeException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
