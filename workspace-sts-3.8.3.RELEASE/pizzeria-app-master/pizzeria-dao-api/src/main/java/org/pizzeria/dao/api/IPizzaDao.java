package org.pizzeria.dao.api;

import java.util.List;

import org.pizzeria.dao.api.exception.DeletePizzaException;
import org.pizzeria.dao.api.exception.SavePizzaException;
import org.pizzeria.dao.api.exception.UpdatePizzaException;
import org.pizzeria.domain.Pizza;

//import fr.pizzeria.exception.DeletePizzaException;
//import fr.pizzeria.exception.SavePizzaException;
//import fr.pizzeria.exception.UpdatePizzaException;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();

boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

default boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
	
	return false;
}
default boolean deletePizza(String codePizza) throws DeletePizzaException{
	
	return false;
}
}