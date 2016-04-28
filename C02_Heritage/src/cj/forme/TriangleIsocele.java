package cj.forme;

public class TriangleIsocele extends Triangle {

	public float perimetre() {
		return (float) (Math.hypot(getLongueur() / 2, getHauteur()) * 2 + getLongueur());
	}

	public TriangleIsocele() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TriangleIsocele(float longueur, float largeur, float hauteur) {
		super(longueur, largeur, hauteur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (super.equals(obj)) { // compare si c'est un triangle
			if (obj instanceof TriangleIsocele){ // compare si il est isocele
				bool = true;
			}
		} 
		return bool;
	}

}
