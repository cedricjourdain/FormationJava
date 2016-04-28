package cj.animaux;

public class Tiger extends Vertebrate {

	public Tiger() {
		// TODO Auto-generated constructor stub
		super("Tigre sauvage", 1.5f, 120f);
		this.setNbPattes(4);
	}

	public Tiger(String name, float sizeAnimal, float weight) {
		super(name, sizeAnimal, weight);
		this.setNbPattes(4);
	}

	public String move() {
		return "leap";
	}
}
