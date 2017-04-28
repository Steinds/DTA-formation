package org.pizzeria.dao.jpa;

import org.pizzeria.dao.api.DaoFactory;
import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.jpa.PizzaDaoImplJpa;

public class DaoJpaFactory implements DaoFactory{
	private IPizzaDao pizzaDao= new PizzaDaoImplJpa();
	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
	}
}
