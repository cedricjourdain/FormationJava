package cj.metier;

public class Parking {
	
	public static int NBPLACES_DEFAUT = 200;
	public static int NBETAGE_DEFAUT = 10;
	
	// Propriétés
	Etage[] etages;

	// Constructeurs
	public Parking() {
		etages = new Etage[NBETAGE_DEFAUT];
		for (int i = 0; i < etages.length; i++) {
			etages[i] = new Etage(NBPLACES_DEFAUT);
		}
	}

	public Parking(int nbEtage) {
		etages = new Etage[nbEtage];
		for (int i = 0; i < etages.length; i++) {
			etages[i] = new Etage(NBPLACES_DEFAUT);
		}
	}
	
	public Parking(int nbEtage, int nbPlace) {
		etages = new Etage[nbEtage];
		for (int i = 0; i < etages.length; i++) {
			etages[i] = new Etage(nbPlace);
		}
	}

}
