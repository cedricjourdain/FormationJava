package cj.tableau;

import cj.forme.Carre;
import cj.forme.Cercle;
import cj.forme.Form2D;
import cj.forme.Rectangle;
import cj.forme.Triangle;
import cj.forme.TriangleEquilateral;
import cj.forme.TriangleIsocele;
import cj.forme.TriangleRectangle;

public class CalculSurTableau {
	static final int TYPE_CERCLE = 2; // final :
	static final int TYPE_RECTANGLE = 1;
	static final int TYPE_CARRE = 0;

	private Form2D[] tab;

	public CalculSurTableau() {
		this.tab = null;
	}

	public CalculSurTableau(int dim) {
		this.tab = new Form2D[dim];
	}

	public Form2D[] getTab() {
		return tab;
	}

	public void setTab(Form2D[] tab) {
		this.tab = tab;
	}

	public void afficheTab() {
		System.out.print("\n[");
		for (int i = 0; i < this.tab.length - 1; i++) {
			// System.out.println(array.getClass().getName());
			System.out.print(i + " " + ((this.tab[i] == null) ? "" : this.tab[i].toString()) + ", ");
		}
		System.out.print(this.tab[this.tab.length - 1] + "]");
		System.out.println("");
	}

	public Form2D[] ajoutAuBout(Form2D forme) {
		/* Ajoute une forme à la dernière case du tableau de forme */
		Form2D[] maForme = new Form2D[this.tab.length + 1];
		for (int i = 0; i < this.tab.length; i++) {
			maForme[i] = this.tab[i];
		}
		maForme[maForme.length - 1] = forme;
		return maForme;
	}

	private Form2D[] ajoutAuMillieu(int indice, Form2D forme) {
		/* Ajoute une forme à la case i du tableau de forme */
		if (this.tab.equals(null)) { // Le test ne marche pas
			System.err.println("On attend en paramète un Form2D[]");
			Form2D[] maForme = new Form2D[1];
			maForme[0] = forme;
			return maForme;
		} else if (indice <= this.tab.length && indice >= 0) {
			Form2D[] maForme = new Form2D[this.tab.length + 1];
			for (int i = 0; i < indice; i++) {
				maForme[i] = this.tab[i];
			}
			maForme[indice] = forme;
			for (int i = indice; i < this.tab.length; i++) {
				maForme[i + 1] = this.tab[i];
			}
			return maForme;
		} else {
			System.err.println("La valeur de l'indice n'est pas bonne fils, pas d'ajout");
			return this.tab;
		}
	}

	public Form2D[] creTab() {
		/*
		 * Creer un tableau de Form2D[] avec diffrentes formes dedans le taleau
		 */
		int lower = 0;
		int higher = 3;
		int nbForme = 10;
		int random;
		float randomLongueur, randomLargeur, randomHauteur;
		Form2D maForme = null;

		for (int i = 0; i < tab.length; i++) { // boucle sur le nombre de forme
			random = (int) (Math.random() * (nbForme - lower)) + lower;
			randomLongueur = (float) (Math.random() * (higher - lower)) + lower;
			randomLargeur = (float) (Math.random() * (higher - lower)) + lower;
			randomHauteur = (float) (Math.random() * (higher - lower)) + lower;

			switch (random) {
			case TYPE_CARRE:
				maForme = new Carre(randomLongueur);
				break;
			case TYPE_RECTANGLE:
				maForme = new Rectangle(randomLongueur, randomLargeur);
				break;
			case TYPE_CERCLE:
				maForme = new Cercle(randomLongueur);
				break;
			case 3:
				maForme = new Triangle(randomLongueur, randomLargeur, randomHauteur);
				break;
			case 4:
				maForme = new TriangleIsocele(randomLongueur, randomLargeur, randomHauteur);
				break;
			case 5:
				maForme = new TriangleRectangle(randomLongueur, randomLargeur, randomHauteur);
				break;
			case 6:
				maForme = new TriangleEquilateral(randomLongueur, randomLargeur, randomHauteur);
				break;
			}
			tab[i] = maForme;
		}
		return tab;
	}

	public Form2D[] suppAuBout() {
		/* Supprime une forme à la dernière case du tableau de forme */
		this.tab[this.tab.length - 1] = null;
		return this.tab;
	}

	public Form2D[] suppAuMillieu(int indice) {
		/* Supprime une forme à la case i du tableau de forme */
		if (indice <= this.tab.length && indice >= 0) {
			Form2D[] maForme = new Form2D[this.tab.length - 1];
			for (int i = 0; i < indice; i++) {
				maForme[i] = this.tab[i];
			}
			for (int i = indice; i < this.tab.length; i++) {
				maForme[i] = this.tab[i + 1];
			}
			return maForme;
		} else {
			System.out.println("La valeur de l'indice n'est pas bonne fils, pas d'ajout");
			return this.tab;
		}
	}

	public Form2D[] tri(Form2D[] t) {
		/* methode de tri croissant avec compteur du nmbre d'operation) */
		for (int i = 0; i < t.length; i++) {
			System.out.print((float) t[i].surface() + " , ");
		}
		System.out.println("");
		int nb = 0;
		boolean b = true;
		while (b) {
			b = false;
			for (int i = 0; i < t.length - 1; i++) {
				if (t[i + 1].surface() < t[i].surface()) {
					Form2D a = t[i];
					t[i] = t[i + 1];
					t[i + 1] = a;
					b = true;
					nb += 3; // pour compter le nombre d'opération
				}
				nb++;
			}
		}
		return t;
	}

	public Form2D[] tri1(Form2D[] t) {
		/* Tri dans l'ordre croissant un tableau de float (methode phillipe) */
		int nb = 0;
		boolean b = true;
		for (int i = 0; i < t.length; i++) {
			System.out.print((float) t[i].surface() + " , ");
		}
		System.out.println("");

		while (b) {
			b = false;
			for (int i = 0; i < t.length - 1; i++) {
				if (t[i].compareTo(t[i + 1]) < 0) {
					Form2D a = t[i];
					t[i] = t[i + 1];
					t[i + 1] = a;
					b = true;
					nb += 3; // pour compter le nombre d'opération
				}
				nb++;
			}
		}
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i].surface() + ",");
		}
		return t;
	}

	public static void triBulleCroissant(float tableau[]) {
		/* Tri dans l'ordre croissant un tableau de float (methode internet) */
		int longueur = tableau.length;
		float tampon = 0;
		boolean permut;

		do {
			permut = false; // hypothèse : le tableau est trié
			for (int i = 0; i < longueur - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (tableau[i] > tableau[i + 1]) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}

}
