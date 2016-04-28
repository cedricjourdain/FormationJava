package CountSemiPrime;

import java.util.ArrayList;

public class CountSemiPrime {

	public static void main(String[] args) {

		CountSemiPrime test = new CountSemiPrime();
		int[] P = { 1, 4, 16 };
		int[] Q = { 26, 10, 20 };
		 int[] sol = test.solution2(26, P, Q);
		 for (int j = 0; j < sol.length; j++) {
		 System.out.println(sol[j] + ", ");
		 }
		//test.init();
	}

	public void init() {
		int N = 26;
		ArrayList<Integer> primeNum = isPrimeFromPrime(N);
		for (Integer integer : primeNum) {
			System.out.println(integer + ", ");
		}
	}

	public int[] solution(int N, int[] P, int[] Q) {
		int[] A = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			int cpt = 0;
			for (int j = P[i]; j <= Q[i]; j++) {
				if (isSemiPrime(j)) {
					cpt++;
				}
			}
			A[i] = cpt;
		}
		return A;
	}

	public int[] solution1(int N, int[] P, int[] Q) {
		int[] A = new int[P.length];
		// Stockage des nomres premiers jusqu'à N
		ArrayList<Integer> primeNum = new ArrayList<>();
		ArrayList<Integer> semiPrimeNum = new ArrayList<>();
		for (int i = 2; i < N; i++) {
			if (isPrime(i)) {
				primeNum.add(i);
			}
		}
		// Stockage des nombres semi-premiers jusqu'à N
		for (int i : primeNum) {
			for (int j : primeNum) {
				if (i * j <= N)
					semiPrimeNum.add(i * j);
			}
		}

		for (int i = 0; i < P.length; i++) {
			int cpt = 0;
			for (int j = P[i]; j <= Q[i]; j++) {
				if (semiPrimeNum.contains(j)) {
					cpt++;
				}
			}
			A[i] = cpt;
		}
		return A;
	}
	
	public int[] solution2(int N, int[] P, int[] Q) {
		int[] A = new int[P.length];
		// Stockage des nomres premiers jusqu'à N
		ArrayList<Integer> primeNum = isPrimeFromPrime(N);
		// Stockage des nombres semi-premiers jusqu'à N
		ArrayList<Integer> semiPrimeNum = new ArrayList();
		for (int i : primeNum) {
			for (int j : primeNum) {
				if (i * j <= N)
					semiPrimeNum.add(i * j);
			}
		}
		//Compte le nombre de semiPrime queries 
		for (int i = 0; i < P.length; i++) {
			int cpt = 0;
			for (int j = P[i]; j <= Q[i]; j++) {
				if (semiPrimeNum.contains(j)) {
					cpt++;
				}
			}
			A[i] = cpt;
		}
		return A;
	}

	public boolean isPrime(int n) {
		if (n == 4)
			return false;
		for (int i = 2; 2 * i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public ArrayList<Integer> isPrimeFromPrime(int n) {
		// renvoie la liste des nombres premiers jusqu'à n
		ArrayList<Integer> arrayPrime = new ArrayList<>();
		boolean b = true;
		arrayPrime.add(2);
		for (int i = 3;   i < n; i++) {
			b = true;
			for (Integer integer : arrayPrime) {
				if (i % integer == 0)
					b = false;
			}
			if (b) {
				arrayPrime.add(i);

			}
		}
		return arrayPrime;
	}

	public boolean isSemiPrime(int n) {
		for (int j = 2; j < n; j++) {
			if (n % j == 0) {
				int diviseur = n / j;
				if (isPrime(j) && isPrime(diviseur)) {
					return true;
				}
			}
		}
		return false;
	}
}
