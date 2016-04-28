package maxProfit;

public class MaxProfit {

	public static void main(String[] args) {

		MaxProfit test = new MaxProfit();
		int[] A = { 23171,21011, 21123, 21366, 21013, 21367 };
		System.out.println(test.solution(A));
		System.out.println(test.maxProfit(A));
	}

	public int solution(int[] A){
		int profit = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				if ((A[j] - A[i])> profit) {
					profit = A[j] - A[i];
				}
			}
		}
		return profit;
	}
	
	public int maxProfit(int[] A) {
		int profit = 0;
		int max = A[0];
		int min = A[0];
		int ind0 = 0;
		int ind1 = 1;

		for (int i = 0; i < A.length-1; i++) {
			if (max < A[i + 1]) {
				max = A[i + 1];
				ind0 = i;
			}

			if (min > A[i + 1]) {
				min = A[i + 1];
				ind1 = i;
			}
		}
		if ((max - min) > 0) {
			profit = max - min;
		}
		return profit;
	}
	
	public int solutionProf(int[] A) {
		int r = 0;
		try {
			int v = A[0];
			int m = 0;
			for (int i = 1; i < A.length; i++) {
				if (A[i] < v) {
					r = m;
					v = A[i];
					m = 0;
				} else if (A[i] > v) {
					if (A[i] - v > m) {
						m = A[i] - v;
					}
				}
			}
			if (m > r) {
				r = m;
			}
		} catch (Exception e) {

		}
		return r;
	}
}
