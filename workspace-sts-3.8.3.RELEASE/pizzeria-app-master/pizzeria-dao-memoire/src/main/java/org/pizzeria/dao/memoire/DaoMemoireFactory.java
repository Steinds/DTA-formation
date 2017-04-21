package org.pizzeria.dao.memoire;

import org.pizzeria.dao.api.DaoFactory;
import org.pizzeria.dao.api.IPizzaDao;


//import fr.pizzeria.Dao.pizza.IPizzaDao;
//import fr.pizzeria.Dao.pizza.PizzaDaoImplFichier;

public class DaoMemoireFactory implements DaoFactory{
	

	private IPizzaDao pizzaDao= new PizzaDaoImpl();
	@Override
	public IPizzaDao getPizzaDao(){
		return pizzaDao;
	}
	
}
