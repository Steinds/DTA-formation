package org.pizzeria.console.ihm;

import java.util.List;
import java.util.Scanner;

import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.api.exception.SavePizzaException;
import org.pizzeria.domain.CategoriePizza;
import org.pizzeria.domain.Pizza;

//import fr.pizzeria.exception.SavePizzaException;

public class NouvellePizzaOptionMenu extends OptionMenu<IPizzaDao> {

	public NouvellePizzaOptionMenu(IPizzaDao pizzas ,String libelle) {
		super(pizzas , libelle);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean execute() {
		
		
		
		@SuppressWarnings("resource")
		Scanner choiceUser = new Scanner(System.in);
		//int a = choiceUser.nextInt();// choiceUser
		String code, nom;
		double prix;
		

		System.out.println("Veuillez saisir le code");
		code = choiceUser.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		nom = choiceUser.next();
		System.out.println("Veuillez saisir le prix");
		prix = choiceUser.nextDouble();
		System.out.println("Veuillez saisir le type de Pizza: VIANDE POISSON SANS_VIANDE");
		String cat = choiceUser.next();
		List<Pizza> listPizza= dao.findAllPizzas();
		//choiceUser.close();
		 
		for( int i=0,j=0;i<listPizza.size();i++){
			if(listPizza.get(i)!=null){ 
			
			j++;
		}}
		boolean out;
		try {
			out = dao.saveNewPizza(new Pizza(code,nom,prix,CategoriePizza.valueOf(cat)));
			if (out)
				System.out.println("done");
			return out;
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
		
	}
		
}
