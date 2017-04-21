package org.pizzeria.dao.memoire;

import java.util.*;

import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.domain.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	List<Pizza> pizzas=new ArrayList<Pizza>();
	int reference = 0;

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
			pizzas.add(pizza);		
		//	return true;	
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		int indice = trouverPizza(codePizza);
		if (indice == -1) {
			return false;
		}
		pizzas.set(indice,pizza);
		return true;
	}

	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		int indice = trouverPizza(codePizza);
		if (indice == -1) {
			return false;
		}
		pizzas.remove(indice) ;
		return true;
	}

	/*public void majRef(Pizza pizza) {
		if (pizza.getId() == -1) {
			pizza.setId(reference++);
		}
	}*/


	/*public int trouverLigneVide() {
		for (int j=0;j<pizzas.size();j++){
			if(pizzas.get(j)== null){
		return j;
		}
			}
		return -1;

	}*/

	public int trouverPizza(String code) {
		for (int j=0;j<pizzas.size();j++){
			
			if(pizzas.get(j).getCode().equals(code)){
				return j;
			}
		}
		return -1;

	}

}
