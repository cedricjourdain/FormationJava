package cj.metier;

import cj.other.Calcul;

public class Lego {
	// Propriete de l'objet
	float longueur;
	float largeur;
	float hauteur;
	private String couleur;
	private String name;
	int nbrePicotLon;
	int nbrePicotLar;

	// Constructeur
	public Lego() {
		this.longueur = 10;
		this.largeur = 1.5f;
		this.hauteur = 2;
		this.couleur = "Rouge";
		this.nbrePicotLar = 2;
		this.nbrePicotLon = 4;
	}

	// Surcharge du constructeur
	public Lego(float longueur, float largeur, float hauteur, String couleur, int nbrePicotLon, int nbrePicotLar) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = "rouge";
		this.nbrePicotLar = nbrePicotLar;
		this.nbrePicotLon = nbrePicotLon;
	}

	// Surcharge du constructeur
	public Lego(float hauteur, String couleur, int nbrePicotLon, int nbrePicotLar) {
		this.couleur = "rouge";
		this.nbrePicotLar = nbrePicotLar;
		this.nbrePicotLon = nbrePicotLon;
		this.hauteur = hauteur;
		Calcul calcul = new Calcul();
		longueur = calcul.calculDim(nbrePicotLon);
		largeur = calcul.calculDim(nbrePicotLar);
	}

	// Surcharge du constructeur
	Lego(Lego lego) {
		this.longueur = lego.getLongueur();
		this.largeur = lego.getLargeur();
		this.hauteur = lego.getHauteur();
		this.couleur = lego.getCouleur();
		Calcul calcul = new Calcul();
		nbrePicotLon = calcul.calculNbPicot(lego.getLongueur());
		nbrePicotLar = calcul.calculNbPicot(lego.getLargeur());
	}

	// Surcharge du constructeur
	Lego(float longueur, float largeur, float hauteur, String couleur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = couleur;
		Calcul calcul = new Calcul();
		nbrePicotLon = calcul.calculNbPicot(longueur);
		nbrePicotLon = calcul.calculNbPicot(longueur);
	}

	// Accesseur & mutateur
	public float getLargeur() {
		Calcul calcul = new Calcul();
		return calcul.calculDim(getNbrePicotLar());
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
		Calcul calcul = new Calcul();
		nbrePicotLar = calcul.calculNbPicot(largeur);
	}

	public float getLongueur() {
		Calcul calcul = new Calcul();
		return calcul.calculDim(getNbrePicotLon());
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
		Calcul calcul = new Calcul();
		nbrePicotLon = calcul.calculNbPicot(longueur);
	}

	public float getHauteur() {
		return this.hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public int getNbrePicotLon() {
		return nbrePicotLon;
	}

	public void setNbrePicotLon(int nbrePicotLon) {
		this.nbrePicotLon = nbrePicotLon;
		Calcul calcul = new Calcul();
		longueur = calcul.calculDim(nbrePicotLon);
	}

	public int getNbrePicotLar() {
		return nbrePicotLar;
	}

	public void setNbrePicotLar(int nbrePicotLar) {
		this.nbrePicotLar = nbrePicotLar;
		Calcul calcul = new Calcul();
		largeur = calcul.calculDim(nbrePicotLar);
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	// Methodes
	void initMonLego(int longueur, int largeur, String couleur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.couleur = couleur;
	}

	void peindreMonLego(String coul) {
		couleur = coul;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
