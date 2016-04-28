
public class Tableau {

	public static void main(String[] args) {
		// Tableau 1D

		// Initialization
		int[] tableau1 = new int[12];
		int[] tableau2;
		tableau2 = new int[12];
		boolean[] tBoolean = new boolean[5];
		System.out.println(tBoolean[2]);

		int[] tableau3 = { 1, 2, 3, 4, 5, 6 };
		System.out.println(tableau2[2]);
		System.out.println(tableau1.length);

		// ------------------------------------
		System.out.print("tableau1[");
		for (int i = 0; i < tableau1.length; i++) {
			System.out.print(tableau1[i]);
			if (i < tableau1.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
		// ------------------------------------
		System.out.print("tableau3[");
		for (int i = 0; i < tableau3.length; i++) {
			System.out.print(tableau3[i]);
			if (i < tableau3.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
		System.out.println("adresse physique : " + tableau3);

		for (int i = 0; i < tBoolean.length; i++) {
			tBoolean[i] = true;
		}

		for (int i = 0; i < tBoolean.length; i++) {
			System.out.print(tBoolean[i] + " ");
		}

		// Tableau 2D
		int[][] image = new int[4][5];
		System.out.println("");
		System.out.println("longueur image 1ere dim: " + image.length);
		System.out.println("longueur image 2eme dim: " + image[0].length);

		int[][] image1 = { { 1, 2, 7 }, { 3, 4, 8 } };
		System.out.println(image1.length + " " + image1[0].length);
		System.out.println("------------------------------------------");
		System.out.println(image1[1][2]);

		for (int i = 0; i < image1.length; i++) {
			for (int j = 0; j < image1[0].length; j++) {
				System.out.print(image1[i][j] + ", ");
			}
			System.out.println("");
		}

		// Tableau 3D
		int[][][] image2 = new int[4][5][3];
		System.out.println("");
		System.out.println("longueur image 1ere dim: " + image2.length);
		System.out.println("longueur image 2eme dim: " + image2[0].length);
		System.out.println("image[0]: " + image2[0]);
		System.out.println("longueur image 3eme dim: " + image2[0][0].length);
		
		//TEST
		int[][] autre = {{1,2,7},{3,4,8},{33,44,85},{331,24,38}};
		System.out.println(autre.length+ " "+autre[0].length);
		System.out.println("autre[1][0] = "+autre[1][0]);
		System.out.println("--------------------------------");
		for (int i = 0; i < image2.length; i++) {
			int[] tab=autre[i];
			for (int j = 0; j < tab.length; j++) {
				System.out.print(tab[j]);
				if (j<tab.length-1) {
					System.out.print(", ");
					
				}
			}
			System.out.println("");
		}
	}

}
