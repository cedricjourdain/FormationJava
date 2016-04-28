package cj.forme;

public class TriangleEquilateral extends Triangle {

	public TriangleEquilateral() {
		// TODO Auto-generated constructor stub
	}

	public TriangleEquilateral(float longueur, float largeur, float hauteur) {
		super(longueur, largeur, hauteur);
		// TODO Auto-generated constructor stub
	}

	public float perimetre() {
		return getLongueur() * 3;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (super.equals(obj)) { // compare si c'est un triangle
			if (obj instanceof TriangleEquilateral) { // compare si il est
														// Equilateral
				bool = true;
			}
		}
		return bool;
	}
}
