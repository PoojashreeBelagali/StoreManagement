/**
 * 
 */
package com.restapi.exception;

/**
 * @author Poojashree B
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServiceException() {
		super();
	}

	/**
	 * @param paramString
	 *            - exception message.
	 * @param paramThrowable
	 *            - exception cause.
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
