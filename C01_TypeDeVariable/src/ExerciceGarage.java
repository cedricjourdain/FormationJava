import java.util.Scanner;

public class ExerciceGarage {

	public static void main(String[] args) {
		int etage = 0;
		float tailleMini = 1.5f;
		float tailleMax = 5.5f;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle est la longueur de votre vehicule ?");
		float tailleVehicule = sc.nextFloat(); // Recupere la longueur du
												// vehicule
		sc.nextLine(); // On vide la ligne avant d'en lire une autre

		if (tailleVehicule <= tailleMini)
			System.out.println("Votre vehicule est trop petit");

		else if (tailleVehicule >= tailleMax)
			System.out.println("Gare ta limmousine au Rez-de-chauss�, t'arrivera pas a la mont� sinon");

		else {
			for (float taille = 1.5f; taille <= 5.5f; taille = taille + 0.5f) {
				etage = (int) (taille / 0.5f - 2);
				if (tailleVehicule >= taille && tailleVehicule < taille + 0.5f) {
					System.out.println("Veuillez garer votre voiture � l'�tage n�" + etage);
					// break;
				}
				etage++;
			}
		}
	}

}
