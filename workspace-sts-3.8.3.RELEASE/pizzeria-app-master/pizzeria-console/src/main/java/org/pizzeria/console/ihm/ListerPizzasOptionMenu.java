package org.pizzeria.console.ihm;

import java.util.List;

import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.domain.Pizza;


public class ListerPizzasOptionMenu extends OptionMenu{
	
  public ListerPizzasOptionMenu(IPizzaDao pizzas, String libelle) {
	  super(pizzas,libelle);
}

@Override
public boolean execute() {
	// TODO Auto-generated method stub
	System.out.println("\n Liste:");
	List<Pizza> listPizza= pizzas.findAllPizzas();
	for (int j = 0; j < listPizza.size(); j++) {
		if (listPizza.get(j) != null) {
			System.out.println(j +" " + listPizza.get(j).toString());
		}
	}
	
	return true;
}
}
