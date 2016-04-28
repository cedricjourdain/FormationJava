public class MainParking {
	static final int TYPE_CITADINE = 0;
	static final int TYPE_LIMOUSINE = 1;
	static final int TYPE_MONOSPACE = 2;
	static final int TYPE_VELO = 3;
	static final int TYPE_MOTO = 4;
	static final int nbTypeVehicule = 5;
	Vehicule typeVehicule;

	public static void main(String[] args) {

		MainParking mainRemplirParking = new MainParking();
		mainRemplirParking.init();
		System.out.println("End of Programme");
	}

	public void init() {

		Parking parking1 = new Parking(4, 10); // (parking(NbreEtage,
													// NbreMaxDePlace)
		remplirParking(parking1);
	}

	public Parking remplirParking(Parking parking) {
		// Initialisation des variables
		/*
		 * float lgrMin = 1.5f; float lgrMax = 5.5f; float largMin = 1.5f; float
		 * largMax = 5.5f;
		 */
		boolean ouvert = true;
		int nbreMaxCitadine =  4 * parking.getNbPlaceMax() / 10;
		int nbreMaxLimousine = 1 * parking.getNbPlaceMax() / 10;
		int nbreMaxMonospace = 2 * parking.getNbPlaceMax() / 10;
		int nbreMaxVelo = 2 * parking.getNbPlaceMax() / 10;
		int nbreMaxMoto = 1 * parking.getNbPlaceMax() / 10;
		int random, cpt = 0, cptCitadine = 0, cptVelo = 0, cptLimousine = 0, cptMonospace = 0, cptMoto = 0;

		System.out.println("parking.getNbPlaceMax() : "+parking.getNbPlaceMax());
		System.out.println("nbreMaxCitadine = "+nbreMaxCitadine+ " nbreMaxLimousine : "+nbreMaxLimousine+ "nbreMaxMonospace : "+nbreMaxMonospace);
		System.out.println("nbreMaxVelo : "+nbreMaxVelo + " nbreMaxMoto : " +nbreMaxMoto);
		while (ouvert !=false) {
			random = (int) (Math.random() * nbTypeVehicule);
			/*
			 * randomLongueur = (float) (Math.random() * (lgrMax - lgrMin)) +
			 * lgrMin; randomLargeur = (float) (Math.random() * (largMax -
			 * largMin)) + largMin;
			 */
			switch (random) {
			case TYPE_CITADINE:
				typeVehicule = new Citadine();
				if (cpt >= parking.getNbPlaceMax()) {
					ouvert = false;
					break;
				} else if (cptCitadine > nbreMaxCitadine) {
					break; //System.out.println("Il n'y a plus de place pour votre voiture");
				} else {
					cptCitadine++;
					cpt++;
				}
				break;
			case TYPE_LIMOUSINE:
				typeVehicule = new Limousine();
				if (cpt >= parking.getNbPlaceMax()) {
					ouvert = false;
					break;
				} else if (cptLimousine >= nbreMaxLimousine) {
					break;//System.out.println("Il n'y a plus de place pour votre Limousine");
				} else {
					cptLimousine++;
					cpt++;
				}
				break;
			case TYPE_MONOSPACE:
				typeVehicule = new Monospace();
				if (cpt >= parking.getNbPlaceMax()) {
					ouvert = false;
					break;
				} else if (cptMonospace > nbreMaxMonospace) {
					
					break; //System.out.println("Il n'y a plus de place pour votre monospace");
				} else {
					cptMonospace++;
					cpt++;
				}
				break;
			case TYPE_VELO:
				typeVehicule = new Velo();
				if (cpt >= parking.getNbPlaceMax()) {
					ouvert = false;
					break;
				} else if (cptVelo >= nbreMaxVelo) {
					break;
					//System.out.println("Il n'y a plus de place pour votre Velo");
				} else {
					cptVelo++;
					cpt++;
				}
				break;
			case TYPE_MOTO:
				typeVehicule = new Moto();
				if (cpt >= parking.getNbPlaceMax()) {
					ouvert = false;
					break;
				} else if (cptMoto >= nbreMaxMoto) {
					break;
					//System.out.println("Il n'y a plus de place pour votre Moto");
				} else {
					cptMoto++;
					cpt++;
				}
				break;
			}
		}
		System.out.println("Le parking est rempli");
		System.out.println("Citadine : " + cptCitadine);
		System.out.println("limousine : " + cptLimousine);
		System.out.println("Monospace : " + cptMonospace);
		System.out.println("Moto : " + cptMoto);
		System.out.println("Velo : " + cptVelo);
		return parking;
	}
}
