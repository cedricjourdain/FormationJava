package cj.metier.marchand;

import java.io.Serializable;

import cj.metier.stock.StockArrayList;

public class Marchand extends Commercant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StockArrayList stockMarchand;
	private StockArrayList stockMarchandPrive;
	private StockArrayList stockMarchandFamille;
	private float limiteStock, limiteStockPrive, limiteStockFamille;

	public Marchand() {
		super();
		stockMarchandPrive = new StockArrayList();
		stockMarchandFamille = new StockArrayList();
	}

	public Marchand(String nom) {
		super(nom);
		stockMarchandPrive = new StockArrayList();
		stockMarchandFamille = new StockArrayList();
	}

	public Marchand(String nom, float limite) {
		super(nom, limite);
		stockMarchandPrive = new StockArrayList();
		stockMarchandFamille = new StockArrayList();
	}

	public Marchand(String nom, float limite, float limiteStockPrive, float limiteStockFamille) {
		super(nom, limite);
		stockMarchand = new StockArrayList();
		stockMarchandPrive = new StockArrayList();
		stockMarchandFamille = new StockArrayList();

		stockMarchand.setLimitePrix(limiteStock);
		stockMarchandPrive.setLimitePrix(limiteStockPrive);
		stockMarchandFamille.setLimitePrix(limiteStockFamille);

	}

	public StockArrayList getStock() {
		return stockMarchand;
	}

	@Override
	public String toString() {
		return " ";
	}

	// getters and Setters
	public void setStock(StockArrayList stock) {
		this.stockMarchand = stock;
	}

	public StockArrayList getStockPrive() {
		return stockMarchandPrive;
	}

	public void setStockPrive(StockArrayList stockPrive) {
		stockPrive = stockPrive;
	}

	public StockArrayList getStockFamille() {
		return stockMarchandFamille;
	}

	public void setStockFamille(StockArrayList stockFamille) {
		stockFamille = stockFamille;
	}
}
