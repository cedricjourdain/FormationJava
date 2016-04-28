package cj.metier.stock;

import java.io.Serializable;
import java.util.ArrayList;

import cj.metier.product.Alimentary;
import cj.metier.product.Consumable;
import cj.metier.product.Product;

public class StockArrayList extends ArrayList<Product> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int NUM_STOCK = 0;

	private String nomDuStock;
	private float limitePrix;
	private float mtTotalStock;

	public StockArrayList() {
		nomDuStock = "stock" + Integer.toString(NUM_STOCK);
		limitePrix = 100;
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public StockArrayList(String nomDuStock) {
		this.nomDuStock = nomDuStock;
		this.limitePrix = 100;
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public StockArrayList(float limitePrix) {
		setLimitePrix(limitePrix);
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public StockArrayList(String nomDuStock, float limitePrix) {
		this.nomDuStock = nomDuStock;
		this.setLimitePrix(limitePrix);
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public float calculSomme() {
		float somme = 0;
		for (int i = 0; i < this.size(); i++) {
			somme += this.get(i).getPrice();
			// this.get(i) : produit correspondant
		}
		return somme;
	}

	@Override
	public void add(int index, Product element) {
		if (limitePrix >= this.calculSomme()) {
			super.add(index, element);
		} else {
		}
	}

	public boolean addPrd(Product e) {
		boolean depassePas = false;
		float somme = this.calculSomme() + e.getPrice();
		if (limitePrix >= somme || limitePrix == 0) {
			Product produtExiste = searchProduct(e);
			if (produtExiste != null) {
				depassePas = produtExiste.rajoute(e);
			} else {
				depassePas = super.add(e);
				if (depassePas) {
					mtTotalStock = somme;
				}
			}

		}
		return depassePas;
	}

	public boolean addProf(Product e) {
		boolean depassePas = false;
		float somme = this.calculSomme() + e.getPrice();

		if (limitePrix >= somme || limitePrix == 0) {
			if (this.contains(e)) {
				Product p = get(indexOf(e));
				p.rajoute(e);
			}
		}
		return depassePas;
	}

	@Override
	public boolean add(Product e) {
		boolean depassePas = false;
		float somme = this.calculSomme() + e.getPrice();
		if (limitePrix >= somme || limitePrix == 0) {
			Product p = null;
			if (this.contains(e)) {
				p = this.get(indexOf(e));
				p.rajoute(e);
			} else {
				depassePas = super.add(e);
				if (depassePas) {
					mtTotalStock = somme;
				}
			}

		}
		return depassePas;
	}

	public boolean add1(Product e) {
		boolean depassePas = false;
		float somme = this.calculSomme() + e.getPrice();

		if (limitePrix >= somme || limitePrix == 0) {

		}
		return depassePas;
	}

	private Product searchProduct(Product e) {
		/* renvoie le produit cherché du stock */
		Product productFind = null;
		for (Product produit : this) {
			if (produit.getNom().equals(e.getNom())) {
				if (produit instanceof Alimentary && e instanceof Alimentary
						|| produit instanceof Consumable && e instanceof Consumable) {
					productFind = produit;
					break;
				}
			}
		}
		return productFind;
	}

	@Override
	public Product remove(int index) {
		Product prod = super.get(index);
		this.mtTotalStock -= prod.getPrice();
		return super.remove(index);
	}

	@Override
	public boolean contains(Object o) {
		boolean bool = false;
		if (searchProduct((Product) o) != null) {
			super.contains(o);
		}
		return bool;
	}

	private int indexOf(Product o) {
		int index = -1;
		for (int i = 0; i < this.size(); i++) {
			Product produit = get(i);
			if (produit.getNom().equals(o.getNom())) {
				if (produit instanceof Alimentary && o instanceof Alimentary
						|| produit instanceof Consumable && o instanceof Consumable) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	public int indexOf1(Object o) {
		int index = -1;
		for (int i = 0; i < this.size(); i++) {
			if (this.contains(o)) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public boolean remove(Object o) {
		Product prod = (Product) o;
		this.setMtTotalStock(this.getMtTotalStock() - prod.getPrice());
		return super.remove(o);
	}

	@Override
	public void clear() {
		this.setMtTotalStock(0);
		super.clear();
	}

	public float getMtTotalStock() {
		return mtTotalStock;
	}

	public void setMtTotalStock(float mtTotalStock) {
		this.mtTotalStock = mtTotalStock;
	}

	@Override
	public String toString() {
		return this.nomDuStock;
	}

	// Getters and Setters
	public String getNomDuStock() {
		return nomDuStock;
	}

	public void setNomDuStock(String nomDuStock) {
		this.nomDuStock = nomDuStock;
	}

	public float getLimitePrix() {
		return limitePrix;
	}

	public void setLimitePrix(float limitePrix) {
		if (limitePrix == 0) {
			this.limitePrix = Float.POSITIVE_INFINITY;
		} else {
			this.limitePrix = limitePrix;
		}
	}

}
