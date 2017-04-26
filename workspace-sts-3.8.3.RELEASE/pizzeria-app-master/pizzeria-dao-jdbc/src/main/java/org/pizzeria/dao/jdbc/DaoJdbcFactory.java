package org.pizzeria.dao.jdbc;

import org.pizzeria.dao.api.DaoFactory;
import org.pizzeria.dao.api.IPizzaDao;


public class DaoJdbcFactory implements DaoFactory{
	private IPizzaDao pizzaDao= new PizzaDaoImplJdbc();
	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
	}

}
