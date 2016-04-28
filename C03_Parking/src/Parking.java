
public class Parking {

	private int nbreEtage;
	private int nbreDePlaceParEtage;
	private int nbPlaceMax;
	private int numPlace;
	

	// Constructeur
	public Parking() {
		nbreEtage = 0;
	}

	public Parking(int nb) {
		nbreEtage = nb;
	}

	public Parking(int nbEtage, int nbPlaceMax) {
		this.nbreEtage = nbEtage;
		this.nbPlaceMax = nbPlaceMax;
		nbreDePlaceParEtage = (int) nbPlaceMax/nbEtage;
	}

	// Methodes
	int getNbreDePlaceParEtage() {
		return nbreDePlaceParEtage;
	}

	public void setNbreDePlaceParEtage(int nbreDePlaceParEtage) {
		this.nbreDePlaceParEtage = nbreDePlaceParEtage;
	}

	public int getNbPlaceMax() {
		return nbPlaceMax;
	}

	public void setNbPlaceMax(int nbPlaceMax) {
		this.nbPlaceMax = nbPlaceMax;
	}

	public int getNbreEtage() {
		return nbreEtage;
	}

	public void setNbreEtage(int nbreEtage) {
		this.nbreEtage = nbreEtage;
	}

	public int getNbrePlaceParEtage() {
		return nbreDePlaceParEtage;
	}

	public void setNbrePlaceParEtage(int nbrePlaceParEtage) {
		this.nbreDePlaceParEtage = nbrePlaceParEtage;
	}

}
