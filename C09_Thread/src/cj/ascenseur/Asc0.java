package cj.ascenseur;

import cj.main.Main;
import cj.personne.Personne;
//import vdd.personne.ThreadPersonne;

public class Asc0 extends Asc {

	public Asc0(Main main) {
		super(main);
	}

	@Override
	public void run() {

		while (!finDeTraitement) {
			rechercherPersonneAttente();

			if (personneEstEnDepart()) {
				deplacerAscenseurDepart();
				personnAscenseur.etat = Personne.ETAT_MOVE;
			}
			if (personneADeplacerArrive()) {
				deplacerAscenseurArrive();
				this.personnAscenseur.etat = Personne.ETAT_ARRIVE;
				this.personnAscenseur = null;
				
			}
			try {
				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean personneADeplacerArrive() {
		boolean b = false;
		if (this.personnAscenseur != null && this.personnAscenseur.etat == Personne.ETAT_MOVE) {
			b = true;
		}
		return b;
	}

	private boolean personneEstEnDepart() {
		boolean b = false;
		if (this.personnAscenseur != null && this.personnAscenseur.etat == Personne.ETAT_DEPART) {
			b = true;
		}
		return b;
	}

	private void deplacerAscenseurArrive() {
		while (etage != personnAscenseur.arrive) {
			try {
				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (personnAscenseur.depart < personnAscenseur.arrive) {
				progression++;
				if (progression % HAUTEUR_ETAGE == 0) {
					progression = 0;
					etage++;
				}
			} else {
				progression--;
				if (progression % HAUTEUR_ETAGE == 0) {
					progression = 0;
					etage--;
				}
			}
			main.aff.repaint();
		}
	}

	private void deplacerAscenseurDepart() {

		while (etage != personnAscenseur.depart) {
			try {
				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (etage < personnAscenseur.depart) {
				progression++;
				if (progression % HAUTEUR_ETAGE == 0) {
					progression = 0;
					etage++;
				}
			} else {
				progression--;
				if (progression % HAUTEUR_ETAGE == 0) {
					progression = 0;
					etage--;
				}
			}
			main.aff.repaint();
		}
	}

	private void rechercherPersonneAttente() {
		// for (int j = 0; j < main.listePersonne.size(); j++) {
		// Personne p = main.listePersonne.get(j);
		// if (p.etat == personnAscenseur.ETAT_ATTENTE) {
		// personnAscenseur = p;
		// p.etat = personnAscenseur.ETAT_DEPART;
		// break;
		// }
		// }
		synchronized (main.listePersonne) {

			for (Personne personne : main.listePersonne) {
				if (personne.etat == Personne.ETAT_ATTENTE) {
					this.personnAscenseur = personne;
					personne.etat = Personne.ETAT_DEPART;
					break;
				}
			}
		}
	}
}
