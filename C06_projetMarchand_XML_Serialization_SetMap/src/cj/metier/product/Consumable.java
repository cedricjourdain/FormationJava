package cj.metier.product;

import java.io.Serializable;

public class Consumable extends Product implements Serializable, Comparable<Product> {

	private static final long serialVersionUID = 1L;
	private int quantity;

	public Consumable() {
		super();
	}

	public Consumable(String nom, float prix) {
		super(nom, prix);
	}

	public Consumable(String nom, float prix, int qte) {
		super(nom, prix);
		this.quantity = qte;
	}

	@Override
	public float getPrice() {
		return getUnitaryPrice() * getQuantity();
	}

	@Override
	public boolean rajoute(Product e) {
		boolean bool = false;
		if (e instanceof Consumable && e.getNom().equals(this.getNom())) {
			Consumable a = (Consumable) e;
			this.setUnitaryPrice((this.getPrice() + a.getPrice()) / (this.getQuantity() + a.getQuantity()));
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Consumable) {
			Consumable e = (Consumable) obj;
			retour = this.getNom().equals(e.getNom());
		}
		return retour;
	}

	public int compareTo(Product p) {
		int retour = 0;
		if (p instanceof Consumable) {
			retour = this.getNom().compareTo(getNom());
		} else if (p instanceof Alimentary) {
			retour = 1;
		}
		return 0;
	}

	// Getters and Setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			this.quantity = 0;
		}
	}

}
