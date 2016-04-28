package equiLeader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class EquiLeader {

	public static void main(String[] args) {
		EquiLeader e = new EquiLeader();
		e.init();

	}

	public void init() {
		int[] A = { 4, 3, 4, 4, 4, 2 };
		System.out.println("solution(A) : " + solution(A));
	}

	public int solution(int[] A) { // 100%
		int r = 0;
		int[] B = A.clone();
		Arrays.sort(B);
		int valMax = 0;
		int nbMax = 0;
		int val = B[0];
		int nb = 1;
		for (int i = 0; i < B.length; i++) {
			if (val == B[i]) {
				nb++;
			} else {
				if (nbMax < nb) {
					valMax = val;
					nbMax = nb;
				}
				val = B[i];
				nb = 1;
			}
		}
		if (nbMax < nb) {
			valMax = val;
			nbMax = nb;
		}

		int nb0 = 0;
		int nb1 = nbMax;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == valMax) {
				nb0++;
				nb1--;
			}
			if (nb0 > (i + 1) / 2 && nb1 > (A.length - i - 1) / 2) {
				r++;
			}
		}
		return r;
	}

	public int solution2(int[] A) { // 88%
		int r = 0;
		ArrayList<Integer> key0 = new ArrayList<Integer>();
		ArrayList<Integer> val0 = new ArrayList<Integer>();
		ArrayList<Integer> key1 = new ArrayList<Integer>();
		ArrayList<Integer> val1 = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (key1.contains(A[i])) {
				int ind = key1.indexOf(A[i]);
				Integer ii = val1.get(key1.indexOf(A[i]));
				val1.set(ind, Integer.valueOf(ii + 1));
			} else {
				key1.add(new Integer(A[i]));
				val1.add(new Integer(1));
				key0.add(new Integer(A[i]));
				val0.add(new Integer(0));
			}
		}
		int valMax = 0;
		int nbMax = 0;
		for (int i = 0; i < key1.size(); i++) {
			int nb = val1.get(i);
			if (nb > nbMax) {
				valMax = key1.get(i);
				nbMax = nb;
			}
		}
		int nb0 = 0;
		int nb1 = nbMax;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == valMax) {
				nb0++;
				nb1--;
			}
			if (nb0 > (i + 1) / 2 && nb1 > (A.length - i - 1) / 2) {
				r++;
			}
		}
		return r;
	}

	public int solution1(int[] A) { // 88%
		int r = 0;
		TreeMap<Integer, Integer> map0 = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map1.containsKey(A[i])) {
				map1.put(A[i], map1.get(A[i]) + 1);
			} else {
				map1.put(A[i], 1);
				map0.put(A[i], 0);
			}
		}
		int valMax = 0;
		int nbMax = 0;
		Set<Entry<Integer, Integer>> set = map1.entrySet();
		for (Entry<Integer, Integer> entry : set) {
			int nb = entry.getValue();
			if (nb > nbMax) {
				valMax = entry.getKey();
				nbMax = nb;
			}
		}
		int nb0 = 0;
		int nb1 = nbMax;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == valMax) {
				nb0++;
				nb1--;
			}
			if (nb0 > (i + 1) / 2 && nb1 > (A.length - i - 1) / 2) {
				r++;
			}
		}
		return r;
	}

}
