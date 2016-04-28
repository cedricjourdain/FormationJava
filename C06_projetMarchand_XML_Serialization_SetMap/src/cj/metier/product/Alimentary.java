package cj.metier.product;

import java.io.Serializable;

public class Alimentary extends Product implements Serializable,Comparable<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float weight;

	public Alimentary() {
		super();
	}

	public Alimentary(String nom, float prix) {
		super(nom, prix);
	}

	public Alimentary(String nom, float prix, float poids) {
		super(nom, prix);
		this.weight = poids;
	}

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return getUnitaryPrice() * getWeight();
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Alimentary) {
			Alimentary e = (Alimentary) obj;

			retour = this.getNom().equals(e.getNom());

		}
		return retour;
	}

	// Getters and Setters
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public boolean rajoute(Product e) {
		boolean bool = false;
		if (e instanceof Alimentary && e.getNom().equals(this.getNom())) {
			Alimentary a = (Alimentary) e;
			this.setUnitaryPrice((this.getPrice() + a.getPrice()) / (this.getWeight() + a.getWeight()));
			bool = true;
		}
		return bool;
	}

	public int compareTo(Product p) {
		int retour = 0;
		if (p instanceof Alimentary) {
			retour = this.getNom().compareTo(getNom());
		} else if (p instanceof Consumable) {
			retour = 1;
		}
		return 0;
	}

}
