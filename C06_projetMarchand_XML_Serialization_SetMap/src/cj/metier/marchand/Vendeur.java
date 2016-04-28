package cj.metier.marchand;

import cj.metier.stock.Stock;

public class Vendeur {

	private Stock stock;
	private Stock stockPrive;
	private Stock stockFamille;

	public Vendeur() {
	}
	
	
	// Getter and Setter
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Stock getStockPrive() {
		return stockPrive;
	}

	public void setStockPrive(Stock stockPrive) {
		this.stockPrive = stockPrive;
	}

	public Stock getStockFamille() {
		return stockFamille;
	}

	public void setStockFamille(Stock stockFamille) {
		this.stockFamille = stockFamille;
	}

}
