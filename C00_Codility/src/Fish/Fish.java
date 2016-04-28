package Fish;
import java.util.ArrayList;

public class Fish {

	public static void main(String[] args) {
		Fish b = new Fish();
		b.init();
	}

	private void init() {
		int[] A = { 4, 3, 2, 1, 5 };
		int[] B = { 1, 0, 0, 0, 0 };
		System.out.println(solution(A, B));
	}

	public int solution(int A[], int B[]) {
		int cpt = A.length;
		for (int i = 0; i < A.length; i++) {
			if (B[i] > B[i + 1]) {
				if (A[i] > A[i + 1]) {
					B[i] = B[i + 1];
				}
			}
		}
		return cpt;
	}

	public int solution1(int A[], int B[]) { // 100%
		int cpt = 0;
		ArrayList<Integer> pile = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (B[i] == 0) {
				cpt++;
				for (int j = pile.size() - 1; j >= 0; j--) {
					if (A[pile.get(j).intValue()] > A[i]) {
						cpt--;
						break;
					} else if (A[pile.get(j).intValue()] < A[i]) {
						cpt--;
						pile.remove(pile.size() - 1);
					}
				}
			} else {
				cpt++;
				pile.add(i);
			}
		}
		return cpt;
	}

	public int solution2(int[] A, int[] B) { // 62%
		int r = A.length;
		int[] pile = new int[A.length];
		int indPile = -1;
		for (int i = 0; i < B.length; i++) {
			if (B[i] == 1) {
				indPile++;
				pile[indPile] = i;
			} else {
				for (int j = 0; j < indPile + 1; j++) {
					if (A[i] > 0) {
						if (A[pile[j]] > A[i]) {
							r--;
							A[i] = 0;
						} else {
							A[pile[j]] = 0;
							r--;
						}
					}
				}
			}
		}
		return r;
	}
}
