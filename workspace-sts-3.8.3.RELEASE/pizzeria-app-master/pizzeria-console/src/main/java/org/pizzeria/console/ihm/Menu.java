package org.pizzeria.console.ihm;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	private Map<Integer,OptionMenu> actions=new HashMap<>();
	private String titre;
	private int nbActions;
	
/*	public Menu(int nbMenus){
		actions = new OptionMenu[nbMenus];
	}*/
	
	public void afficher(){
		System.out.println(titre);	
		for (int i=0;i< actions.size();i++){
			if(actions.get(i)!=null){
		System.out.println(i+1 + ". " + actions.get(i).getLibelle());}}
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean ajouterAction(OptionMenu option){
	//	if(nbActions<actions.size()){
			actions.put(nbActions,option);
			nbActions++;
			return true;
	//		}
	//	return false;
	}
	public boolean execute(int indiceOption){
		if(indiceOption-1<nbActions){
			actions.get(indiceOption-1).execute();
			return true;
		}
		return false;
	}
}
