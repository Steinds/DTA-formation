package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.Persistence;

import org.pizzeria.console.ihm.ListerPizzasOptionMenu;
import org.pizzeria.console.ihm.Menu;
import org.pizzeria.console.ihm.MettreAJourOptionMenu;
import org.pizzeria.console.ihm.NouvellePizzaOptionMenu;
import org.pizzeria.console.ihm.SupprimerOptionMenu;
import org.pizzeria.dao.api.DaoFactory;
import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.api.exception.SavePizzaException;
import org.pizzeria.dao.fichier.DaoFichierFactory;
import org.pizzeria.dao.memoire.DaoMemoireFactory;
import org.pizzeria.domain.CategoriePizza;
import org.pizzeria.domain.Pizza;

import com.github.lalyos.jfiglet.FigletFont;

//import org.pizzeria.Dao.DaoFactory;
//import fr.pizzeria.Dao.DaoFichierFactory;
//import fr.pizzeria.Dao.DaoMemoireFactory;
//import fr.pizzeria.Dao.pizza.IPizzaDao;
//import fr.pizzeria.Dao.pizza.PizzaDaoImpl;
//import fr.pizzeria.exception.SavePizzaException;
//import fr.pizzeria.ihm.ListerPizzasOptionMenu;
//import fr.pizzeria.ihm.Menu;
//import fr.pizzeria.ihm.MettreAJourOptionMenu;
//import fr.pizzeria.ihm.NouvellePizzaOptionMenu;
//import fr.pizzeria.ihm.SupprimerOptionMenu;
//import fr.pizzeria.model.*;



public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Persistence.generateSchema("pizzeria-unit", null);
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String value = bundle.getString("dao.impl");	
		Class<?> maClasse = Class.forName(value);
		DaoFactory factory = (DaoFactory) maClasse.newInstance();
		
		
		
//		DaoFactory daoFactory = new DaoFichierFactory();
		IPizzaDao dao = factory.getPizzaDao();
		dao.findAllPizzas().forEach(p->p.toString());
		
		
		
		
		//IPizzaDao dao = new PizzaDaoImpl();
		try {
			dao.saveNewPizza(new Pizza("PEP", "Peperoni", 12.50F,CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("MAR", "Margherita", 14.00F,CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("REI", "La Reine", 11.50F,CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("FRO", "La 4 fromages", 12.00F,CategoriePizza.SANS_VIANDE));
			dao.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50F,CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00F,CategoriePizza.SANS_VIANDE));
			dao.saveNewPizza(new Pizza("ORI", "L'orientale", 13.50F,CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("IND", "L'indienne", 14.00F,CategoriePizza.VIANDE));
			
		} catch (SavePizzaException e) {
			
			throw new SavePizzaException("erreur création pizza");
		}
		
		//int i;

		//listePizza = new Pizza[50];
		
		//initialisationPizza(listePizza);
		
		@SuppressWarnings("resource")
		Scanner mainScan = new Scanner(System.in);
		
		
		Menu menu = new Menu();
		String asciiArt = FigletFont.convertOneLine("PizzaYOLO");
	    System.out.println(asciiArt);
		menu.setTitre("****** Pizzeria Administration *****");		
		menu.ajouterAction(new ListerPizzasOptionMenu(dao, "Liste des Pizzas"));
		menu.ajouterAction(new NouvellePizzaOptionMenu(dao,"Ajout d'une nouvelle Pizza"));
		menu.ajouterAction(new MettreAJourOptionMenu(dao,"MAJ d'une nouvelle Pizza"));
		menu.ajouterAction(new SupprimerOptionMenu(dao,"Suppression d'une Pizza"));
		boolean stop = false;
		while (!stop) {
			menu.afficher();
			int a = mainScan.nextInt();// choiceUser
			menu.execute(a);
		}

			
/*
			switch (a) {
			case 1:
				System.out.println("« Liste des pizzas »");
		//		listerPizza(listePizza);
				break;
			case 2:
				System.out.println("« Ajout d’une nouvelle pizza »");
				String code, nom;
				double prix;

				System.out.println("Veuillez saisir le code");
				code = choiceUser.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nom = choiceUser.next();
				System.out.println("Veuillez saisir le prix");
				prix = choiceUser.nextDouble();
				i = 0;
				while (i < 50 && listePizza[i] != null) {
					i++;
				}
				listePizza[i] = new Pizza(i, code, nom, prix);
				break;
			case 3:
				System.out.println("« Mise à jour d’une pizza »");
			//	listerPizza(listePizza);
				System.out.println("Veuillez choisir la pizza à modifier");
				int num = choiceUser.nextInt();
				if (num == 99) {
					break;
				}
				System.out.println("Veuillez saisir le code");
				code = choiceUser.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nom = choiceUser.next();
				System.out.println("Veuillez saisir le prix");
				prix = choiceUser.nextDouble();
				listePizza[num] = new Pizza(num, code, nom, prix);
				break;
			case 4:
			//	System.out.println("« Suppression d’une pizza »");
			//	listerPizza(listePizza);
			//	System.out.println("Veuillez choisir la pizza à supprimer");
				
				num = choiceUser.nextInt();
				listePizza[num] = null;
				break;
			case 99:
				System.out.println("« Aurevoir ☹️ »");
				stop = true;
				break;
			}
		}
*/
	}

/*	private static void menu() {

		//Menu.titre();
		System.out.println("1.Lister les pizzas");
		System.out.println("2.Ajouter une nouvelle pizza");
		System.out.println("3.Mettre à jour une pizza");
		System.out.println("4.Supprimer une pizza");
		System.out.println("99.Sortir");
	}*/

/*ListerPizzasOptionMenu

	private static void listerPizza(Pizza[] listePizza) {
		for (int j = 0; j < 50; j++) {
			if (listePizza[j] != null) {
				System.out.println("" + listePizza[j].getId() + "|" + listePizza[j].getCode() + "|"
						+ listePizza[j].getNom() + "|" + listePizza[j].getPrix() + "€");
			}
		}
	}

	private static void initialisationPizza(Pizza[] listePizza) {
		listePizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50F);
		listePizza[1] = new Pizza(1, "MAR", "Margherita", 14.00F);
		listePizza[2] = new Pizza(2, "REI", "La Reine", 11.50F);
		listePizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00F);
		listePizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50F);
		listePizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00F);
		listePizza[6] = new Pizza(6, "ORI", "L’orientale", 13.50F);
		listePizza[7] = new Pizza(7, "IND", "L’indienne", 14.00F);
	}
*/
}
