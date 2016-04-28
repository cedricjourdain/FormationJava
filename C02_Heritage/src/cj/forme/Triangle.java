package cj.forme;

public class Triangle extends Form2D {

	public Triangle() {
		super();
	}

	public Triangle(float longueur, float largeur, float hauteur) {
		super(longueur, largeur, hauteur);
	}

	public float surface() {
		return getLongueur() * getHauteur() / 2;
	}

	public float perimetre() {
		return getLongueur() + getLargeur() + getHauteur();
	}

	@Override
	public int compareTo(Form2D arg0) {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj instanceof Triangle) {
			Triangle t = (Triangle) obj;
			if (this.getLongueur() == t.getLongueur() && this.getLargeur() == t.getLargeur()
					&& this.getHauteur() == t.getHauteur()) {
				System.out.println(this);
				bool = true;
			}
		}
		return bool;
	}
}
