package demo;
public class DemoCodility {

	public static void main(String[] args) {
		DemoCodility test = new DemoCodility();
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		int rep = test.solution(a);
		System.out.println(rep);
		a = new int[100000];
		int indice = (int) (Math.random() * 100000);
		a[indice] = 1;
		rep = test.solution(a);
		System.out.println(rep);
		int[] c = { 2147483647, 2147483647, 2147483647 };
		rep = test.solution(c);
		System.out.println(rep);
		System.out.println("FIN");

	}

	public int solution(int[] A) {
		int res = -1;
		for (int i = 0; i < A.length; i++) {
			long s1 = 0;
			long s2 = 0;
			for (int j = 0; j < i; j++) {
				s1 += A[j];
			}
			for (int j = i + 1; j < A.length; j++) {
				s2 += A[j];
			}
			//System.out.println("i="+i+" ("+s1+","+s2+")");
			if (s1 == s2) {
				res = i;
				break;
			}
		}
		return res;
	}

	public int solution3(int[] A) {
		int res = -1;
		if (A != null && A.length > 0) {
			long s1 = 0;
			long s2 = 0;
			for (int i = 1; i < A.length; i++) {
				s2 += A[i];
			}
			if (s1 != s2) {
				for (int i = 1; i < A.length; i++) {
					s1 += A[i - 1];
					s2 -= A[i];
					if (s1 == s2) {
						res = i;
						break;
					}
				}
				//			if (s1 == s2) {
				//				res=A.length-1;
				//			}
			} else {
				res = 0;
			}
		}
		return res;
	}

	public int solution2(int[] A) {
		int res = -1;
		try {
			for (int i = 0; i < A.length; i++) {
				int s1 = 0;
				int s2 = 0;
				for (int j = 0; j < i; j++) {
					s1 += A[j];
				}
				for (int j = A.length - 1; j > i; j--) {
					s2 += A[j];
				}
				//System.out.println("i="+i+" ("+s1+","+s2+")");
				if (s1 == s2) {
					res = i;
					break;
				}
			}
		} catch (Exception e) {
		}
		return res;
	}

}
