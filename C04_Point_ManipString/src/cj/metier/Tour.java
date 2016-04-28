package cj.metier;

public class Tour {
	private String nom;
	private Lego[] maTour;
	private Lego legoType;

	public Tour() {
		// this.nom = nom;
		// this.maTour = new Lego1[100];
	}

	public Tour(String nom, Lego legoType) {
		this.nom = nom;
		this.legoType = legoType;
		this.maTour = new Lego[1000];
		for (int i = 0; i < maTour.length; i++) {
			// Lego1 leLego = new Lego1(legoType.getHauteur(),
			// legoType.getCouleur(),
			// legoType.getNbrePicotLon(),legoType.getNbrePicotLar());
			Lego leLego = new Lego(legoType);
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Lego[] getMaTour() {
		return maTour;
	}

	public void setMaTour(Lego[] maTour) {
		this.maTour = maTour;
	}

}
