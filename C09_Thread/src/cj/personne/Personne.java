package cj.personne;

public class Personne {
	public static int getEtatAttente() {
		return ETAT_ATTENTE;
	}

	public static int getEtatDepart() {
		return ETAT_DEPART;
	}

	public static int getEtatMove() {
		return ETAT_MOVE;
	}

	public static int getEtatArrive() {
		return ETAT_ARRIVE;
	}

	public static int CPT=0;
	public static int NB_ETAGE=20;
	
	public static final int ETAT_ATTENTE = 0;
	public static final int ETAT_DEPART = 1;
	public static final int ETAT_MOVE = 2;
	public static final int ETAT_ARRIVE = 3;

	public String nom;
	public int etat;
	public int depart;
	public int arrive;

	public Personne() {
		nom=Integer.toString(CPT);
		CPT++;
		etat = ETAT_ATTENTE;
		depart = (int) (Math.random() * NB_ETAGE);
		arrive = (int) (Math.random() * NB_ETAGE);
		while (arrive == depart) {
			arrive = (int) (Math.random() * NB_ETAGE);
		}
	}
	
	public String toString() {
		return nom;
	}
}