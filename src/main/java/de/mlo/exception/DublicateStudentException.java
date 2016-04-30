package de.mlo.exception;

public class DublicateStudentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8636336181261776549L;
	
	public DublicateStudentException() {
	}

	public DublicateStudentException(String arg0) {
		super(arg0);
	}

	public DublicateStudentException(Throwable arg0) {
		super(arg0);
	}

	public DublicateStudentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DublicateStudentException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
