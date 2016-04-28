package CyclicRotation;

/**
 * 
 * @author philippe Allangros = Allan Gros VDD PH salut FrVDD Yoloooo modif de
 *         cedric modif de Adeline modif d'Amandine modif de Floriane modif de
 *         Alexia modif de MAthias modif de Patick modif damien
 *         modif Baptiste
 *         modif Souad Erreur 23
 *         modif 2 Souad 
 */
public class CyclicRotation {
	public static void main(String[] args) {
		CyclicRotation b = new CyclicRotation();
		b.init();
	}

	private void init() {
		int[] a = { 3, 8, 9, 7, 6 };
		affTab(solution(a, 3));
	}

	/**
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int[] solution(int[] A, int K) {
		int[] n = null;
		if (A != null) {
			n = new int[A.length];
			for (int i = 0; i < A.length; i++) {
				int j = (i + K) % A.length;
				n[j] = A[i];
			}
		}
		return n;
	}

	public void affTab(int[] t) {
		System.out.print("[");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]);
			if (i < t.length - 1) {
				System.out.print(" ,");
			}
		}
		System.out.println("]");
	}
}
