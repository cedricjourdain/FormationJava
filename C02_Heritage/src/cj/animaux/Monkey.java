package cj.animaux;

public class Monkey extends mammal {

	public Monkey(String name, float sizeAnimal, float weight) {
		super(name, sizeAnimal, weight);
	}

	public Monkey() {
	}

	// M�thodes
	public String move() {
		String nameTypeOfMove = "Jump on trees";
		// nameTypeOfMove = "Monkey " + super.move() + " and run and " +
		// nameTypeOfMove;
		nameTypeOfMove = "Monkey run and " + nameTypeOfMove;
		return nameTypeOfMove;
	}

}
