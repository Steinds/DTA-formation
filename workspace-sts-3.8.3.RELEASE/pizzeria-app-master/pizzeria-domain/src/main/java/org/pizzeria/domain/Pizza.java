package org.pizzeria.domain;

public class Pizza {
 private int id;

 private String code;
 
 private String nom;

 private double prix;

 private CategoriePizza cat;
 public static int reference;
 
 
@Deprecated 
public Pizza(int id,String code, String nom, double prix){
	this.id=id;
	this.code = code;
	this.nom = nom;
	this.prix = prix;
}
@Deprecated
public Pizza ( String code,String nom, double prix){
	id=reference++;
	this.code=code;
	this.nom=nom;
	this.prix=prix;
}
public Pizza ( String code,String nom, double prix, CategoriePizza cat){
	id=reference++; 
	this.code=code;
	this.nom=nom;
	this.prix=prix;
	this.setCat(cat);
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public double getPrix() {
	return prix;
}

public void setPrix(double prix) {
	this.prix = prix;
}
public boolean equals(Pizza pizza1,Pizza pizza2){
	if (pizza1.getCode()==pizza2.getCode()){
		return true;
	}
	else {
		return false;
	}		
}

public String toString(){
	/*
	String chaine ="";
	try{
		for(Field field: this.getClass().getDeclaredFields()){
			ToString annotation = field.getAnnotation(ToString.class);
			if ( annotation!=null){
				boolean toUpperCase
			}
		}
	}*/
	return id+ " "+code+" "+nom+" "+prix+" "+cat;
	
}

public CategoriePizza getCat() {
	return cat;
}

public void setCat(CategoriePizza cat) {
	this.cat = cat;
}

}
