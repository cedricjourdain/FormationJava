package cj.forme;

public class Rectangle extends Form2D {

	public Rectangle() {
	}

	public Rectangle(float longueur) {
		super(longueur);
	}

	public Rectangle(float largeur, float longueur) {
		super(longueur, largeur);
	}

	public float surface() {
		return getLargeur() * getLongueur();
	}

	public float perimetre() {
		return 2 * (getLongueur() + getLargeur());
	}

	@Override
	public int compareTo(Form2D o) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean equals(Rectangle obj) {
		boolean bool = true;
		if ((this instanceof Rectangle) && this.getLongueur() == obj.getLongueur()
				&& this.getLargeur() == obj.getLargeur()) {
			bool = true;
		} else
			bool = false;
		return bool;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = super.equals(obj);
		bool &= (obj instanceof Rectangle);
		// La condition suivante fait la meme chose que bool &= (obj instanceof
		// Rectangle);
		// if(bool){
		// if(obj instanceof Rectangle){
		// bool = true;
		// }
		// }
		return bool;
	}
}
