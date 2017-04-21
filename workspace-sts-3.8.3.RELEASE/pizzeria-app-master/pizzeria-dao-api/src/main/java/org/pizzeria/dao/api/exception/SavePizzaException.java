package org.pizzeria.dao.api.exception;

import java.io.IOException;

public class SavePizzaException extends StockageException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavePizzaException(IOException e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(String string) {
		// TODO Auto-generated constructor stub
	}

}
