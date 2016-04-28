package cj.forme;

public class TriangleRectangle extends Triangle {

	public float perimetre() {
		return (float) Math.sqrt(Math.hypot(getLongueur(), getLargeur())) + getLargeur() + getLongueur();
	}

	public TriangleRectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TriangleRectangle(float longueur, float largeur, float hauteur) {
		super(longueur, largeur, hauteur);
		// TODO Auto-generated constructor stub
	}

	public boolean equals(Form2D obj) {

		if (this.getLargeur() == obj.getLargeur() && this.getHauteur() == obj.getHauteur()) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (super.equals(obj)) { // compare si c'est un triangle
			if (obj instanceof TriangleRectangle) { // compare si c'est un
													// Rectangle
				bool = true;
			}
		}
		return bool;
	}

}
