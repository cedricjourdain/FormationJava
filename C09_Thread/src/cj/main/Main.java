package cj.main;

import cj.ascenseur.Asc0;
import cj.ascenseur.ListeAscenseur;
import cj.personne.ListePersonne;
import cj.personne.ThreadPersonne;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	public ListePersonne listePersonne;
	public ListeAscenseur listeAscenseur;
	public Affichage aff;

	public boolean sortie;

	public Main() {
		listePersonne = null;
		listeAscenseur = null;
		sortie = false;
	}

	public void init() {
		aff = new Affichage(this);
		aff.init();
//		for (int i = 0; i < 6; i++) {
//			Asc0 ascen = new Asc0(this);
//			listeAscenseur.add(ascen);
//			ascen.start();
//		}

		listePersonne = new ListePersonne();
		listeAscenseur = new ListeAscenseur(this);
		listePersonne.run();

		//ThreadPersonne p = new ThreadPersonne();
		//p.start();

		// for (int i = 0; i < 200; i++) {
		//
		// listePersonne.add(p);
		// }


		// Asc0[]tabAsc=new Asc0[6];
		// for (int i = 0; i < 6; i++) {
		// Personne p=new Personne();
		// Asc0 Ascen=new Asc0(this);
		// Ascen.personne=p;
		// listeAscenseur.add(Ascen);
		// Ascen.start();
		// }

		// Personne gens = new Personne();
		// Asc0 essai = new Asc0(this);
		// essai.personne = gens;
		// gens.depart = 5;
		// gens.arrive = 10;
		// listeAscenseur.add(essai);
		// Personne gone = new Personne();
		// Asc0 essai2 = new Asc0(this);
		// essai2.etage = 10;
		// essai2.personne = gone;
		// gone.depart = 5;
		// gone.arrive = 2;
		// listeAscenseur.add(essai2);
		// essai2.start();
		// essai.start();
	}
}
