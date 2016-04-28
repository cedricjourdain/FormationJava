package cj.personne;

import cj.main.Main;

public class ThreadPersonne extends Thread {

	public void run(Main main) {
		
		Personne personne=new Personne();
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	
		main.listePersonne.add(personne);
	}
}
