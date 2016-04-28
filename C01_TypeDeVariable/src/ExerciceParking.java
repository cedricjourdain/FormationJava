public class ExerciceParking {
	// generer un nbre aleatoire = numero d'immarticulation
	// si j ai le vehicule : quel etage et et quel numero dimmatriculation
	// donner le nombre de vehicule par etage en fct de l'arrivé des
	// vehicules successifs
	// conserver le numero de passage de chaque vehicule
	// moyenne de la taille des vehicules
	// garder le numero de place et d'étage de chaque vehicule

	public static void main(String[] args) {
		// Initialisation des variables
		float tailleMin = 1.5f;
		float tailleMax = 5.5f;
		float tailleVehicule = 1f;
		int nombreVehiculeMax = 3, nombreVehiculeMin = 1;
		int nombreVehicule = (int) (Math.random() * (nombreVehiculeMax - nombreVehiculeMin)) + nombreVehiculeMin;
		int nombrePlaceMax = 5, nombrePlaceMin = 1;
		int numeroPlace = 0;
		int[] nombreplaceUtilise = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		float[][] tabVehicule = new float[nombreVehicule][3];
		System.out.println("Aujourd'hui il y a " + nombreVehicule + " voitures qui sont venu dans le parking");
		// Interaction HM
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println(
		 * "Quelle est la longueur de votre vehicule ?"); float tailleVehicule =
		 * sc.nextFloat(); // Recupere la longueur du // vehicule sc.nextLine();
		 * // On vide la ligne avant d'en lire une autre
		 */

		// Boucle sur le nombre de vehicule entrant dans le parking
		for (int i = 0; i < nombreVehicule; i++) {
			int etage = 0;
			tailleVehicule = (float) (Math.random() * (tailleMax - tailleMin)) + tailleMin;

			if (tailleVehicule <= tailleMin)
				System.out.println("Votre vehicule est trop petit");
			else if (tailleVehicule >= tailleMax) {
				if (nombreplaceUtilise[0] >= 200) {
					System.out.println("Parking Complet");
				} else {
					numeroPlace = (int) (Math.random() * (nombrePlaceMax - nombrePlaceMin)) + nombrePlaceMin;
					System.out.println("Veuillez vous garer au Rez-de-chaussé à la place n°" + numeroPlace);
					nombreplaceUtilise[0]++;
					// !!! ICI PB La place peut etre occupé
					tabVehicule[i][2] = numeroPlace;
				}
			} else {
				tabVehicule[i][0] = tailleVehicule;
				for (float taille = 1.5f; taille <= 5.5f; taille = taille + 0.5f) {
					etage = (int) (taille / 0.5f - 2);
					if (nombreplaceUtilise[i] >= 200) {
						System.out.println("Parking Complet");
						break;
					} else {
						if (tailleVehicule >= taille && tailleVehicule < taille + 0.5f) {
							numeroPlace = (int) (Math.random() * (nombrePlaceMax - nombrePlaceMin)) + nombrePlaceMin;
							System.out.println("Veuillez garer votre voiture à l'étage n°" + etage + " à la place n°"
									+ numeroPlace);
							// break;
							// etage++;
							// System.out.println("etage : " + etage);
							nombreplaceUtilise[etage]++;
							// !!! ICI PB La place peut etre occupé
							tabVehicule[i][2] = numeroPlace;
						}
					}
					tabVehicule[i][1] = etage;
				}
			}
			tabVehicule[i][0] = tailleVehicule;
			System.out.println("tabVehicule["+i+"][0] = "+tabVehicule[i][0]);
		}
		// MOYENNE
		float[] moyenneTemp = new float[9];
		float compteur = 1f;
		for (int j = 0; j < 9; j++) {
			System.out.println("Il y a " + nombreplaceUtilise[j] + " place utilisée à l'étage " + j);

			for (int i = 0; i < nombreVehicule; i++) {
				if (tabVehicule[i][1] == j) {
					moyenneTemp[j] += tabVehicule[i][0];
					
					compteur++;
				}
			}
			//System.out.println("moyenne temp : " + moyenneTemp[j]);

			moyenneTemp[j] /= compteur;
			System.out.println(
					"étage : " + j + " : Moyenne vehicule = " + moyenneTemp[j]);
		}
	}
}
