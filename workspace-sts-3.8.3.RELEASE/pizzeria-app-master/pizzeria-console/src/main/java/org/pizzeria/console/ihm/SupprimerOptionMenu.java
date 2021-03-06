package org.pizzeria.console.ihm;

//import java.util.List;
import java.util.Scanner;

import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.api.exception.DeletePizzaException;
//import org.pizzeria.domain.Pizza;

//import fr.pizzeria.exception.DeletePizzaException;


public class SupprimerOptionMenu extends OptionMenu<IPizzaDao> {

	public SupprimerOptionMenu(IPizzaDao pizzas,String libelle) {
		super(pizzas, libelle);
		// TODO Auto-generated constructor stub
	}

	public boolean execute() {
		// TODO Auto-generated method stub
	//	List<Pizza> listPizza= pizzas.findAllPizzas();
		@SuppressWarnings("resource")
		Scanner choiceUser = new Scanner(System.in);		
		System.out.println("Veuillez choisir la pizza à supprimer(code)");
		String code =choiceUser.next();
		//choiceUser.close();
		try {
			dao.deletePizza(code);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//listePizza[num] = null;
		return false;
	}

}
