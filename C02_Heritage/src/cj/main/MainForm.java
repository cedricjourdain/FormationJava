package cj.main;

import cj.forme.Carre;
import cj.forme.Cercle;
import cj.forme.Form2D;
import cj.forme.Rectangle;
import cj.forme.Triangle;
import cj.forme.TriangleEquilateral;
import cj.forme.TriangleIsocele;
import cj.forme.TriangleRectangle;
import cj.tableau.CalculSurTableau;

//Objet : superclasse de java (Mere de toute classe)
// toString() : méthode définit par défaut ds la classe Form2D;
// array[i].toString() apelle la méthode rédefinit dans la sous
// classe si on lui file un objet dont la methode toString est
// redéfinit
// Dans sysout (array[i] équivalent à array[i].toString() car sysout
// attend une chaine de charactere, il va dc chercher
// automatiquement la méthode ds l'objet qui renvoie un string cad
// toString();

public class MainForm {
	static final int TYPE_CERCLE = 2; // final :
	static final int TYPE_RECTANGLE = 1;
	static final int TYPE_CARRE = 0;
	int nbForm = 10;
	private Form2D[] tabForm = new Form2D[nbForm];
	private float[] tabSurface = new float[nbForm];

	public static void main(String[] args) {
		MainForm mainForm = new MainForm();
		mainForm.init();
		// mainForm.creTab();
		mainForm.toString();
	}

	private void init() {
		
		 Carre carre = new Carre(6); carre.setPosx(4); carre.setPosy(4);
		 System.out.print(carre.getPosx() + ", " + carre.getPosy());
		 System.out.println("\t -------------------"); System.out.println("Le périmètre de mon carre vaut : " + carre.perimetre());
		 System.out.println("La surface de mon carre vaut : " +carre.surface()); System.out.println("\t -------------------");
		// creTab();
		 
		float somme = sommeTotal();
		System.out.println(somme);

		/*
		 * triBulleCroissant(tabSurface); affichage(); tri(tabForm);
		 * System.out.println("hello"); toString(); afficheTab(tri(tabForm));
		 * afficheTab(tabForm); tabForm = ajoutAuBout((Form2D[]) tabForm, new
		 * Triangle()); afficheTab(tabForm); tabForm = ajoutAuMillieu((Form2D[])
		 * tabForm, 36458, new Triangle()); afficheTab(tabForm); tabForm =
		 * ajoutAuMillieu(tabForm, -5, new Triangle()); tabForm =
		 * ajoutAuMillieu(null, -5, new Triangle());
		 * 
		 * tabForm = ajoutAuMillieu(tabForm, 5, null); afficheTab(tabForm);
		 */
		// creer une méthode qui va avoir pour vocation de découvirir un objet
		// dans le tableau
		// nom méthode : contain(param Form2D)
		// la methode nous indique si form2D existe
		// redefinir la méthode equals(Objet)

		Cercle c = new Cercle(45);
		Rectangle r = new Rectangle(12, 33);
		Carre a = new Carre(45);
		Cercle c1 = new Cercle(34);
		Form2D f = new Cercle(45);
		Object x = new Rectangle(45, 12);
		Object c2 = new Cercle(3456);
		Triangle t = new Triangle(1, 1, 1);
		Triangle t1 = new Triangle(3, 1, 1);
		TriangleRectangle t2 = new TriangleRectangle(1, 1, 1);
		TriangleEquilateral t3 = new TriangleEquilateral(1, 1, 1);
		TriangleIsocele t4 = new TriangleIsocele(1, 1, 1);
		TriangleIsocele t5 = new TriangleIsocele(1, 1, 1);

		boolean res = c.equals(r);
		System.out.println(res);
		boolean resFaux = c1.equals(r);
		boolean resVrai = c1.equals(c1);
		boolean resVrai1 = c1.equals(c);
		boolean resFaux1 = c1.equals(c2);

		boolean res1 = t.equals(t1);
		boolean res2 = t.equals(t);
		boolean res3 = t1.equals(t2);
		boolean res4 = t3.equals(t4);
		boolean res5 = t5.equals(t4);

		System.out.println("cercle = rectangle : " + res + "\t cercle = rectangle : " + resFaux
				+ "\t cercle1 = cercle1 : " + resVrai + "\t cercle1 = cercle3 : " + resFaux1);

		System.out.println("Triangle(1,1,1) = Triangle(3,1,1) : " + res1 + "\t Triangle(1,1,1) = Triangle(1,1,1) : "
				+ resFaux + "\t Triangle(3,1,1) = TriangleRectangle(1,1,1) : " + res3
				+ "\t TriangleEquilateral(1,1,1) = TriangleIsocele(1,1,1) : " + res4
				+ "\t TriangleIsocele(1,1,1) = TriangleIsocele(1,1,1) : " + res5);

		System.out.println("contain(t,tabForm) : " + contain(t, tabForm));

		Form2D[] tableau = new Form2D[10];
		tableau[0] = (Form2D) x;
		tableau[1] = f;
		tableau[2] = t;
		tableau[3] = t1;
		tableau[4] = t2;
		tableau[5] = t3;
		System.out.println("contain(t,tableau) : " + contain(t, tableau));

		CalculSurTableau tableau1 = new CalculSurTableau(30);
		Form2D[] toto = tableau1.getTab();
		toto[4] = new Cercle(4);
		tableau1.getTab()[4] = new Cercle(4);

		CalculSurTableau tableau2 = new CalculSurTableau(30);
		tableau2.getTab()[2] = new Cercle(30);
		tableau2.afficheTab();
		tableau2.ajoutAuBout(new Rectangle(1, 2));
		tableau2.afficheTab();
	}

	private void affichage() {
		System.out.println("Nombre de forme : " + tabForm.length);
		System.out.println("");
		System.out.println(tabForm.toString());
	}

	private void afficheTab(Form2D[] array) {
		System.out.print("\n[");
		for (int i = 0; i < array.length - 1; i++) {
			// System.out.println(array.getClass().getName());
			System.out.print(i + " " + ((array[i] == null) ? "" : array[i].toString()) + ", ");
		}
		System.out.print(array[array.length - 1] + "]");
		System.out.println("");
	}

	public boolean contain(Form2D forme, Form2D[] tab) {
		/* Indique si le tableau de Form2D contient bien une forme */
		boolean bool = false;
		for (int i = 0; i < tab.length; i++) {
			if (forme.equals(tab[i])) {
				System.out.println("true");
				bool = true;
				break;
			} else {
				System.out.println("false");
				bool = false;
			}
		}
		return bool;
	}

	private float sommeTotal() {
		/* Calcul la somme des surfaces de chaque forme d'un objet Form2D[] */
		float surfaceGlobale = 0;
		for (int i = 0; i < tabForm.length; i++) {
			surfaceGlobale += tabForm[i].surface();
		}
		return surfaceGlobale;
	}
}
