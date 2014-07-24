package com.edu.udea.util.exception;

import org.apache.log4j.Logger;
/**
 * Clase excepcion utilizada para controlar las excepciones que puedan ocurren en el dao, Hereda de excepcion
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */

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