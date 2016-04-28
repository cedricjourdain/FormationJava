package cj.metier.product;

import java.io.Serializable;

public abstract class Product implements Serializable,Comparable<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int CPT = 0; // Static : variable visible partout

	// Propriétés :
	private int id;
	private String name;
	private float unitaryPrice;

	public Product() {
		id = CPT;
		CPT++;
	}

	public Product(String nom, float prix) {
		this.name = nom;
		this.unitaryPrice = prix;
		id = CPT;
		CPT++;
	}

	// Methodes :
	public abstract float getPrice();

	public abstract boolean rajoute(Product e);

	@Override
	public String toString() {
		return "Product " + id + " : " + name + " : " + getPrice() + " $";
	}

	// Getters and Setters
	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String nom) {
		this.name = nom;
	}

	public float getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(float unitaryPrice) {
		unitaryPrice = unitaryPrice;
	}

}
