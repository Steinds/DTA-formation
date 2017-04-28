package org.pizzeria.console.ihm;




public abstract class OptionMenu<T>{
 
 protected T dao;
 private String libelle;
 


public OptionMenu(T dao,String libelle) {
	super();
	this.libelle = libelle;
	this.dao = dao;
}

public abstract boolean execute() ;

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}
 
}
