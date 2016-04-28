package cj.forme;

public class Cercle extends Form2D {

	public Cercle() {
		super();
	}

	public Cercle(float longueur) {
		super(longueur);
		setLongueur(longueur);
		setLargeur(longueur);
	}

	public double getRayon() {
		return getLongueur() / 2;
	}

	public float perimetre() {
		return (float) (2 * Math.PI * getLongueur() / 2);
	}

	public float surface() {
		// return Math.PI * getRayon() * getRayon();
		return (float) ((Math.pow(getLongueur() / 2, 2)) * Math.PI);
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj instanceof Cercle) {
			Cercle c = (Cercle) obj;
			if (this.getLongueur() == c.getLongueur()) {
				System.out.println(this);
				bool = true;
			}
		} else
			bool = false;
		return bool;
	}

}
