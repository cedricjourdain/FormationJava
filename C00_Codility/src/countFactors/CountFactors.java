package countFactors;

public class CountFactors {

	public static void main(String[] args) {
		CountFactors test = new CountFactors();
		int n = 24;
		System.out.println(test.solution(n));
	}

	public int solution(int n) {
		int cpt = 0;
		for (int i = 1; i <= (double) Math.sqrt(n); i++) {
			if (n % i == 0 && i * i != n) {
				cpt = cpt + 2;
			} else if (n % i == 0 && i * i == n) {
				cpt = cpt + 1;
			}
		}
		return cpt;
	}

}
