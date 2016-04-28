package cj.animaux;

public class Perroquet extends Vertebrate {

	private int nbPattes;

	public Perroquet() {
		super("Perroquet sauvage", 0.3f, 1f);
		nbPattes = 2;
	}

	public Perroquet(String name, float sizeAnimal, float weight) {
		super(name, sizeAnimal, weight);
		nbPattes = 2;
		// TODO Auto-generated constructor stub
	}

	public String move() {
		return "fly";
	}

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

}
