
public abstract class Vehicule {

	private float L, l, h;
	private int couleur;

	public Vehicule() {

	}

	public Vehicule(float L, float l) {
		this.L = L;
		this.l = l;
		this.h = 1.5f;
	}

	public Vehicule(float L, float l, float h) {
		this.L = L;
		this.l = l;
		this.h = h;
	}

	public float getL() {
		return L;
	}

	public void setL(float L) {
		this.L = L;
	}

	public float getl() {
		return l;
	}

	public void setl(float l) {
		this.l = l;
	}

	public float geth() {
		return h;
	}

	public void seth(float h) {
		this.h = h;
	}

	public float surfaceVehicule() {
		return getL() * getl();
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
}
