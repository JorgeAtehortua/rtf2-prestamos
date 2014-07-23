package com.edu.udea.util.exception;

import org.apache.log4j.Logger;


public class DAOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(DAOException.class);

	public DAOException() {
		super();
		log.error(this.getMessage(), this);
	}

	public DAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public DAOException(String arg0) {
		super(arg0);
		log.error(arg0, this);
	}

	public DAOException(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage(), arg0);
	}

}