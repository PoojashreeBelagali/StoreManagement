package com.restapi.exception;

/**
 * @author Poojashree B
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DAOException() {
		super();
	}

	/**
	 * @param paramString
	 *            - exception message.
	 * @param paramThrowable
	 *            - exception cause.
	 */
	public DAOException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

}
