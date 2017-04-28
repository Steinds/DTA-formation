package org.pizzeria.domain;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "CODE", unique = true)
	private String code;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRIX")
	private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORIE")
	private CategoriePizza cat;
	public static int reference;

	public Pizza() {

	}

	@Deprecated
	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	@Deprecated
	public Pizza(String code, String nom, double prix) {
		id = reference++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza cat) {
//		id = reference++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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

	public boolean equals(Pizza pizza1, Pizza pizza2) {
		if (pizza1.getCode() == pizza2.getCode()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		/*
		 * String chaine =""; try{ for(Field field:
		 * this.getClass().getDeclaredFields()){ ToString annotation =
		 * field.getAnnotation(ToString.class); if ( annotation!=null){ boolean
		 * toUpperCase } } }
		 */
		return id + " " + code + " " + nom + " " + prix + " " + cat;

	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
