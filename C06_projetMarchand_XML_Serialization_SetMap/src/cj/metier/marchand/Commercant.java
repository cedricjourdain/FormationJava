package cj.metier.marchand;

import java.io.Serializable;

import cj.metier.stock.StockArrayList;

public class Commercant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomMarchand;
	private StockArrayList monStock;
	
	public Commercant(){
		monStock = new StockArrayList();
	}
	
	public Commercant(String nomMarchand){
		monStock = new StockArrayList();
		setNomMarchand(nomMarchand);
	}
	public Commercant( float limite){
		monStock = new StockArrayList(limite);
		nomMarchand = "";
	}
	public Commercant(String nomMarchand, float limite){
		monStock = new StockArrayList(limite);
		setNomMarchand(nomMarchand);
	}
	
	public String getNomMarchand() {
		return nomMarchand;
	}

	public void setNomMarchand(String nomMarchand) {
		this.nomMarchand = nomMarchand;
	}

	public StockArrayList getMonStock() {
		return monStock;
	}

	public void setMonStock(StockArrayList monStock) {
		this.monStock = monStock;
	}
}
