package cj.forme;

public class Carre extends Rectangle {

	public Carre() {
		super();
	}

	public Carre(float cote) {
		super(cote);
	}

	public Carre(float largeur, float hauteur) {
		super(largeur, hauteur);
	}

	public float perimetre() {
		return 4 * getLongueur();
	}

	public float surface() {
		return getLongueur() * getLongueur();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bool = super.equals(obj);
		return bool;
	}

}
