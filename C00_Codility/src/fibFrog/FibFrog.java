package fibFrog;

import java.util.ArrayList;

public class FibFrog {

	public static void main(String[] args) {

		FibFrog test = new FibFrog();
		test.init();
	}

	private void init() {
		int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
		System.out.println(solution(A));
	}

	public int solution(int[] A) {
		boolean sortir = false;
		int cpt = 0;
		int indDeb = A.length;

		ArrayList<Integer> fibArray = new ArrayList<>();
		fibArray.add(1);
		fibArray.add(1);
		for (int i = 2; i < A.length; i++) {
			fibArray.add(fibArray.get(i - 2) + fibArray.get(i - 1));
		}

		while (!sortir) {
			for (int i = indDeb - 1; i >= 0; i--) {
				if (fibArray.contains(indDeb + 1)) {
					cpt++;
					sortir = true;
					break;
				} else if (fibArray.contains(indDeb - i) && A[i] == 1) {
					indDeb = i;
					cpt++;
				}
				// else if(fibArray.contains(indDeb -)){
				//
				// }
			}
			if (cpt == 0) {
				cpt = -1;
				sortir = true;
			}
		}
		return cpt;
	}

	public int solution1(int[] A) {
		int res = 0;

		// Création Fibonnacci :
		ArrayList<Integer> fibArray = new ArrayList<>();
		fibArray.add(1);
		fibArray.add(2);
		for (int i = 2; i < A.length; i++) {
			fibArray.add(fibArray.get(i - 2) + fibArray.get(i - 1));
		}

		ArrayList<Integer> positionsDeDepart = new ArrayList<Integer>();
		positionsDeDepart.add(-1);
		ArrayList<Integer> posTrouvee = null;

		while (positionsDeDepart.size() > 0) {
			posTrouvee = rechercherPosPossible(fibArray, A, positionsDeDepart);
			if (posTrouvee.get(posTrouvee.size() - 1) == A.length) {
				res++;
				break;
			} else {
				positionsDeDepart.clear();
				positionsDeDepart.addAll(posTrouvee);
				posTrouvee.clear();
			}
		}
		return res;
	}

	public ArrayList<Integer> rechercherPosPossible(ArrayList<Integer> f, int[] A,
			ArrayList<Integer> positionDeDepart) {
		ArrayList<Integer> positionsTrouvee = new ArrayList<Integer>();
		// partir de toutes le positions actuelles
		for (Integer posDebut : positionDeDepart) {
			for (Integer nbFibo : f) {
				int saut = posDebut + nbFibo;
				if (saut < A.length) {
					if (A[saut] == 1) {
						positionsTrouvee.add(saut);
					}
				}

			}
		}
		return positionsTrouvee;
	}

}
