package passingCard;
public class PassingCard {
	/** Prefix Sums : PassingCars */

	public static void main(String[] args) {
		PassingCard c = new PassingCard();
		int[] empty = {};
		System.out.println("Empty : " + c.solution(empty) + " " + c.solution1(empty));
		int[] single = { 1 };
		System.out.println("Single : " + c.solution(single) + " " + c.solution1(single));
		int[] d = { 0, 1 };
		System.out.println("Deux : " + c.solution(d) + " " + c.solution1(d));
		int[] a = { 0, 1, 0, 1, 1 };
		System.out.println(c.solution(a));
	}

	public int solution(int[] A) {
		long nb = 0;
		long n=0;
		for (int i = A.length-1; i >= 0; i--) {
			if (A[i] == 1) {
				n++;
			} else {
				nb+=n;
				if (nb > 1000000000) {
					nb=-1;
					break;
				}
			}
		}
		return (int) nb;
	}

	public int solution1(int[] A) {
		int nb = 0;
		for (int i = 0; i < A.length-1; i++) {
			if (A[i] == 0) {
				sortir: for (int j = i+1; j < A.length; j++) {
					if (A[j]==1) {
						nb++;
						if (nb > 1000000000) {
							nb=-1;
							break sortir;
						}
					}
				}
			}
		}
		return nb;
	}

	public String toString(int[] a) {
		String s = "[";
		for (int i = 0; i < a.length; i++) {
			s += Integer.valueOf(a[i]).toString();
			if (i < a.length - 1) {
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}