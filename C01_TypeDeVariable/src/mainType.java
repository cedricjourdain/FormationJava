import java.util.Scanner;

public class mainType {

	public static void main(String[] args) {
		byte a = 0x34; // base hexadecimale
		byte a1 = 052; // base octale
		byte a2 = 0x7F; // borne sup des bytes 128 ça passe pas
		byte b = 1;
		int c = a + b;
		System.out.println(a);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(c);
		int d = 5;
		int e = c + d;
		System.out.println(c + " + " + d + " = " + e);
		int f = 0x7FFFFFFF;
		int f1 = 0x80000000;
		System.out.println("f = 0x7FFFFFFF = " + f);
		System.out.println("f1 = 0x80000000 = " + f1);
		f++;
		System.out.println(f);
		int g = 100;
		int h = 7;
		float i = 2.4f;
		float j = g / h * i;
		System.out.println("j = " + j);
		float k = i * g / h;
		System.out.println("k = " + k);
		int l = g / h;
		System.out.println("l = " + l);
		float m = (float) g / h; // Le (float) cast uniquement le g
		float m1 = ((float) g / h); // ici ça cast l'ensemble. -> a eviter
									// puisque ça fais rien au final

		double p = (100l + 12) / 3f;
		double p1 = (100l + 12) / 3d;
		double p2 = (double) (100l + 12) / 3f;
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);

		// Test variable boolean
		boolean vrai = true;
		boolean faux = false;
		boolean res = vrai & faux;
		System.out.println(res);
		boolean res1 = vrai | faux;
		System.out.println(res1);
		boolean res2 = faux ^ faux;
		System.out.println(res2);
		int q = 0xF0;
		int r = 0x0F;
		int s = q | r;
		System.out.println(s);

		char t = 'é';
		int t1 = (int) t;
		int u = t + 1;
		System.out.println(t + " " + u);
		System.out.println(t1);
		char v = '\u0061';
		System.out.println(v);

		// Test condition
		if (!(5 < 4) && 13 < 12)
			System.out.println("OK");
		else
			System.out.println("Pas OKKK");

		double w = 100d / 3d;
		float x = 100f / 3f;
		if (w == x)
			System.out.println("ok");
		else
			System.out.println("Not Ok");

		int titi = 12;
		{
			int toto = 3;
			System.out.println(toto + " " + titi);
		}
		// System.out.println(toto +" " + titi); // ne marche pas car toto a
		// l'interieur {}

		titi = 54;
		Scanner sc = new Scanner(System.in);
//		/*
//		 * System.out.println("Veuillez saisir un nombre :"); int nombre =
//		 * sc.nextInt(); // On vide la ligne avant d'en lire une autre
//		 * sc.nextLine(); switch (nombre) { case 1: System.out.println(
//		 * "nombre = " + nombre); break; case 3: System.out.println("nombre = "
//		 * + nombre); break; case 5: System.out.println("nombre = " + nombre);
//		 * break; case 10: System.out.println("nombre = " + nombre); break;
//		 * 
//		 * default: System.out.println(
//		 * "On ne connait pas vraiment la valeur de nombre"); break; }
//		 * 
//		 * int longueurDeMonvehicule = 2; // [m] switch (longueurDeMonvehicule)
//		 * { case 1: System.out.println(
//		 * "je peux ranger mon vehicule dans le garage a velo"); break; case 2:
//		 * System.out.println("je peux ranger mon vehicule à l'étage 2"); case
//		 * 3: System.out.println("je peux ranger mon vehicule à l'étage 3");
//		 * break; case 4: System.out.println(
//		 * "je peux ranger mon vehicule à l'étage 4"); break;
//		 * 
//		 * default: System.out.println("je peux pas ranger mon vehicule");
//		 * break; }
//		 * 
//		 * System.out.println("_________________________________________"); int
//		 * lng = 5; for (int indice = 2; indice < 7; indice++) { if (lng ==
//		 * indice) { int etage = indice - 1; System.out.println(
//		 * "je vais à l'étage " + etage); }
//		 * 
//		 * }
//		 */

		
	}
}
