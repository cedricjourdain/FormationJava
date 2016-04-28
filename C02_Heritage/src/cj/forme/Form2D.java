package cj.forme;

public abstract class Form2D implements Comparable<Form2D> {
	private int posx, posy;
	private float longueur, largeur, hauteur;
	private int couleur;
	public static int NBX = 10;
	public static int NBY = 3;
	public static int PAS = 1;
	public static int IND = 1;

	public Form2D() {
		posx = 10 + (IND % NBX) * PAS;
		posy = 10 + (IND % NBX) * PAS;
	}

	// private boolean equals(Form2D obj) {
	// boolean bool = true;
	// if (this.getClass().getName().equalsIgnoreCase(obj.getClass().getName())
	// && this.getLongueur() == obj.getLongueur()) {
	// bool = true;
	// } else
	// bool = false;
	// return bool;
	// }


	public Form2D(float longueur) {
		this.longueur = longueur;
	}

	public Form2D(float longueur, float largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public Form2D(float longueur, float largeur, float hauteur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() { // return "Ma forme 2D est : " +
		// this.getClass().getName() + " : " + surface();
		return this.getClass().getName() + " : " + surface();

	}

	@Override
	public boolean equals(Object obj) {
		Form2D f = (Form2D) obj;
		boolean bool = false;
		if (f.getLongueur()== getLongueur() && f.getLargeur() == getLargeur()) {
			bool = true;
		}
		return bool;
	}

	@Override
	public int compareTo(Form2D autreForme) {
		double surfaceThis = surface();
		double surfaceAutre = autreForme.surface();
		// double surfaceThis = perimetre();
		// double surfaceAutre = autreForme.perimetre();
		int resultat = 0;

		if (surfaceThis < surfaceAutre) {
			resultat = -1;
		} else if (surfaceThis > surfaceAutre) {
			resultat = 1;
		}
		return resultat;
	}

	public abstract float perimetre();

	public abstract float surface();

}
