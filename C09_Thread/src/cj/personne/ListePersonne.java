package cj.personne;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean sortie;

	public ListePersonne() {
		sortie = false;
	}

	@Override
	public void run() {
		while (!sortie) {
			Personne personne = new Personne();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			synchronized (this) {
				this.add(personne);
				if (personne.etat == Personne.ETAT_ARRIVE) {
					this.remove(personne);
				}
			}
		}

	}
}
