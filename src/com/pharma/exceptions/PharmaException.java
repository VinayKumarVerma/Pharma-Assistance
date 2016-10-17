/**
 * 
 */
package com.pharma.exceptions;

/**
 * @author vinay.v
 * 
 *         This an userdefined Exception Class to throw any exception related to
 *         the DataBase Implementation logic and SQLExceptions
 *
 */
public class PharmaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * PharmaException with no arguments
	 */
	public PharmaException() {
		super();
	}

	/**
	 * PharmaException with String arguments
	 * 
	 * @param message
	 */
	public PharmaException(String message) {
		super(message);
	}

	/**
	 * PharmaException with Throwable Cause arguments
	 * 
	 * @param cause
	 */
	public PharmaException(Throwable cause) {
		super(cause);
	}

	/**
	 * PharmaException with String and Throwable arguments
	 * 
	 * @param message
	 * @param cause
	 */
	public PharmaException(String message, Throwable cause) {
		super(message, cause);
	}

}
