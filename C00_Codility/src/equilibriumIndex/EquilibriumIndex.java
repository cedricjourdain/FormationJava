package equilibriumIndex;

public class EquilibriumIndex {

	public static void main(String[] args) {
		EquilibriumIndex test = new EquilibriumIndex();
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		int sol = test.solution(a);
		System.out.println("Solution : " + sol);
		System.out.println("End of Program");

		a = new int[100000];
		int indice = (int) (Math.random() * 100000);
		a[indice] = -1;
		sol = test.solution(a);
		System.out.println("Solution : " + sol);
		int[] c = { 2147483647, 2147483647, 2147483647 };
		sol = test.solution(a);
		System.out.println("Solution : " + sol);

	}

	public int solution(int[] A) {
		int res = -1;
		for (int i = 0; i < A.length; i++) {
			long sum1 = 0;
			long sum2 = 0;
			for (int j = 0; j < i; j++) {
				sum2 += A[j];
			}
			for (int j = A.length - 1; j > i; j--) {
				sum1 += A[j];
			}
			if (sum1 == sum2) {
				res = i;
				break;
			}
		}
		return res;
	}

}
