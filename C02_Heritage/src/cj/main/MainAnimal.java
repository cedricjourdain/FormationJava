package cj.main;

import cj.animaux.Animal;
import cj.animaux.Monkey;
import cj.animaux.Tiger;

public class MainAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAnimal testAnimal = new MainAnimal();
		testAnimal.init();
	}

	// On veut quitter le main car il est static d'ou la créatio du init()
	public void init() {
		// Animal animal = new Animal("unknow animal", 0.7f, 35f);
		Tiger tigre = new Tiger();
		Tiger tigre1 = new Tiger("unknow animal", 0.7f, 35f);
		tigre.setName("Tigrou");
		System.out.println(tigre.getNbPattes());

		Monkey mooky = new Monkey();
		System.out.println(mooky.move());

		Animal tigre2 = new Tiger(); // Instancie une classe fille dans la classe mere
		System.out.println(tigre2.move());

	}

}
