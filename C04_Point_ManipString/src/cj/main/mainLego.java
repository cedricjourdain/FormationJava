package cj.main;

import cj.metier.Lego;
import cj.metier.Lego;
import cj.other.Calcul;

public class mainLego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainLego mainLego = new mainLego();
		mainLego.init();
	}

	private void init() {
//		Lego monPremierLego = null;
//		monPremierLego = new Lego("mon premier lego", 12, 7, 3);
//		monPremierLego.renommerLego("mon premier lego");
//		Lego monSecondLego = new Lego("mon second lego", 5, 3, 5);
//		monSecondLego.renommerLego("mon second Lego");
//		monPremierLego.largeur = 5;
//		int coul = 2;
//		monSecondLego.couleur = coul;
//		monSecondLego.longueur = monPremierLego.largeur;
//
//		int long1 = 12;
//		int lar1 = 5;
//		int cou1 = 3;
//		monPremierLego.initMonLego(long1, lar1, cou1);
//		monSecondLego.initMonLego(13, 24, 3);
//		monSecondLego.peindreMonLego(7);
//		System.out.println("La couleur de mon 1er lego "+monPremierLego.getCouleur());
//		System.out.println("La couleur de mon 2me lego "+monSecondLego.getCouleur());

		Lego lego1 = new Lego();
		Lego lego2 = new Lego(6f, 1.5f, 0.2f, "rouge", 8, 2);
		Lego lego3 = new Lego(0.8f, "rouge", 6, 4);
		int nbrePicotLar = lego2.getNbrePicotLar();
		int nbrePicotLon = lego2.getNbrePicotLon();
		Calcul calcul = new Calcul();
		float dimLon = calcul.calculDim(lego2.getNbrePicotLon());
		float dimLar = calcul.calculDim(lego2.getNbrePicotLar());
		System.out.println("Les dimensions du lego sont " + dimLon + " en longueur et " + dimLar + " en largeur");

		String[] colors = { "blanc", "bleu", "vert", "jaune", "noir", "rouge", "gris" };
		Lego[] tour = new Lego[100];
		int[] tabCpt = new int[colors.length];

		for (int i = 0; i < tour.length; i++) {
			Lego lego4 = new Lego();
			int numeroCouleur = (int) (Math.random() * (colors.length));
			System.out.println("couleur actuelle : " + colors[numeroCouleur]);
			lego4.setCouleur(colors[numeroCouleur]);
			tour[i] = lego4;
			tabCpt[numeroCouleur]++;
		}

		for (int i = 0; i < tabCpt.length; i++) {
			System.out.println("Il y a " + tabCpt[i] + " legos " + colors[i] + " dans la tour");

		}
		Lego[] tour2 = { new Lego(), new Lego(), new Lego(), new Lego(), new Lego(), new Lego(), new Lego() };
		System.out.println(tour2.length);
		Lego[] tour3 = tour;

		// faire 6 tours et rassembler les couleurs pour faire des tours de
		// couleurs
		int cptMax = 0;
		for (int i = 0; i < colors.length; i++) {
			if (cptMax < tabCpt[i]) {
				cptMax = tabCpt[i];
			}
		}
		Lego[][] toursCouleurUni = new Lego[colors.length][cptMax];
		for (int i = 0; i < tour.length; i++) { // Boucle sur le nombre de
												// lego
			Lego lego5 = tour[i];
			String couleurLego = lego5.getCouleur();
			int indiceCouleur = 0;

			for (int j = 0; j < colors.length; j++) {
				if (colors[j].equals(couleurLego)) {
					indiceCouleur = j;
					break;
				}
			}
			int tailleTour = 0;
			while (toursCouleurUni[indiceCouleur][tailleTour] != (null)) {
				tailleTour++;
			}
			toursCouleurUni[indiceCouleur][tailleTour] = lego5;
		}
		// afficher les resultats
		// optimisation du code...
	}
}
