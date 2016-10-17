/**
 * 
 */
package com.pharma.exceptions;


/**
 * @author vinay.v
 * 
 *         This is an bussiness Exception Class used to throw business
 *         Exceptions As specified by the Client
 *
 */
public class PharmaBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PharmaBusinessException() {
		super();
	}

	/**
	 * @param message
	 */
	public PharmaBusinessException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PharmaBusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PharmaBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
