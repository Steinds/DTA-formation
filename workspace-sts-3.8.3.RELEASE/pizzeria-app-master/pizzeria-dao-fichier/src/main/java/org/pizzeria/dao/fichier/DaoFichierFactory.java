package org.pizzeria.dao.fichier;

import org.pizzeria.dao.api.DaoFactory;
import org.pizzeria.dao.api.IPizzaDao;

//import fr.pizzeria.Dao.pizza.IPizzaDao;
//import fr.pizzeria.Dao.pizza.PizzaDaoImplFichier;

public class DaoFichierFactory implements DaoFactory {
	private static final String DATA_DIR= "data";

	private IPizzaDao pizzaDao= new PizzaDaoImplFichier(DATA_DIR);
	@Override
	public IPizzaDao getPizzaDao(){
		return pizzaDao;
	}

}
