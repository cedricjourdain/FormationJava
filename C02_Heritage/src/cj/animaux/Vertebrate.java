package cj.animaux;

public abstract class Vertebrate extends Animal {
	public Vertebrate(String name, float sizeAnimal, float weight) {
		super(name, sizeAnimal, weight);
	}

	public Vertebrate() {
		super();
	}

	// public String move() {
	// String nameTypeOfMove = "";
	// nameTypeOfMove = super.move() + " " + nameTypeOfMove;
	// return nameTypeOfMove;
	// }

	public abstract String move();

	public int nbOs() {
		return 100;
	}
}
