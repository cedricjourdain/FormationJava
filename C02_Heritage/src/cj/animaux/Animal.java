package cj.animaux;

public abstract class Animal {

	private String name = "";
	private float sizeAnimal = 0;
	private float weight = 0;
	private int nbPattes = 0;

	public Animal() {
		this.name = "Unknow";
		this.sizeAnimal = 0;
		this.weight = 0;
	}

	public Animal(String name, float sizeAnimal, float weight) {
		this.name = name;
		this.sizeAnimal = sizeAnimal;
		this.weight = weight;
	}

	// Méthodes
	public abstract String move();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSizeAnimal() {
		return sizeAnimal;
	}

	public void setSizeAnimal(float sizeAnimal) {
		this.sizeAnimal = sizeAnimal;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

}
