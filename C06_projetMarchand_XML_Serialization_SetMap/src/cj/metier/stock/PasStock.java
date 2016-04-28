package cj.metier.stock;

import java.util.ArrayList;
import cj.metier.product.Product;

public class PasStock {

	private ArrayList<Product> monStock;
	private ArrayList<Product> monStockPrive;
	private ArrayList<Product> monStockFamille;

	public PasStock() {
		monStock = new ArrayList<Product>();
	}

	// Getters and setters
	public ArrayList<Product> getMonStock() {
		return monStock;
	}

	public void setMonStock(ArrayList<Product> monStock) {
		this.monStock = monStock;
	}

	public ArrayList<Product> getMonStockPrive() {
		return monStockPrive;
	}

	public void setMonStockPrive(ArrayList<Product> monStockPrive) {
		this.monStockPrive = monStockPrive;
	}

	public ArrayList<Product> getMonStockFamille() {
		return monStockFamille;
	}

	public void setMonStockFamille(ArrayList<Product> monStockFamille) {
		this.monStockFamille = monStockFamille;
	}

}
