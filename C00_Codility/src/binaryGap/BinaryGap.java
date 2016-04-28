package binaryGap;

public class BinaryGap {

	public static void main(String[] args) {

		BinaryGap b = new BinaryGap();
		b.init();
	}

	private void init() {
		// long N = (int) (Math.random() * 2147483647);
		System.out.println(solution(17));
		System.out.println(solution(137));
		System.out.println(solution(529));
		System.out.println(solution(0x00800101));
	}

	public int solution(int N) {
		int n = 0;
		int cpt = 0;
		boolean begin = false;

		while (N >= 1) {
			int reste = N % 2;
			if (reste == 1) {
				if (!begin) {
					n = 0;
					begin = true;
				} else {
					n = Math.max(n, cpt);
				}
			} else {
				cpt++;
			}
			N = N / 2;
		}
		return n;
	}

	public int solution1(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);

		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("1")) {
				break;
			}
		}
		int cpt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("0")) {
				cpt++;
			} else {
				if (cpt > n) {
					n = cpt;
				}
				cpt = 0;
			}
		}
		return cpt;
	}

	public int solution2(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ").trim();
		String comp = " ";
		for (int i = 0; i < 29; i++) {
			if (!s.contains(comp)) {
				break;
			}
			comp += " ";
		}
		System.out.println(s);
		return comp.length();

	}

	public int solutionString(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ");
		s = s.trim();
		String[] ls = s.split("1");
		for (int i = 0; i < ls.length; i++) {
			n = Math.max(ls[i].length(), n);
		}
		System.out.println("Le plus grand Gap est de : " + n);

		return n;
	}

	public void toBinary(int N) {
		int quotient = N;
		int reste = 0;
		String binaireInv = "";
		String binaire = "";
		int n = 0;

		while (quotient >= 1) {
			reste = quotient % 2;
			quotient = quotient / 2;
			if (reste == 1) {
				binaireInv = binaireInv + '1';
			} else {
				binaireInv = binaireInv + '0';
			}
		}
		System.out.println(binaireInv);
		while (n <= binaireInv.length() - 1) {
			binaire = binaire + binaireInv.charAt(binaireInv.length() - 1 - n);
			n++;
		}
		System.out.println("La valeur binaire de " + N + " est : " + binaire);
		System.out.println(binaire.length());
	}

	public int solution5(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		int deb = s.indexOf("1");
		int suivant = deb;
		boolean sortir = false;
		while (!sortir) {
			suivant = s.indexOf("1", deb + 1);
			if (suivant < 0) {
				sortir = true;
			} else {
				int val = (suivant - deb - 1);
				if (n < val) {
					n = val;
				}
				deb = suivant;
			}
		}
		System.out.println(s);
		return n;
	}

	public int solution4(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ").trim();
		String comp = " ";
		for (int i = 0; i < 29; i++) {
			if (!s.contains(comp)) {
				break;
			}
			comp += " ";
		}
		System.out.println(s);
		return comp.length();
	}

	public int solution3(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("1")) {
				break;
			}
		}
		int cpt = 0;
		for (int j = i + 1; j < s.length(); j++) {
			if (s.substring(j, j + 1).equals("0")) {
				cpt++;
			} else {
				if (cpt > n) {
					n = cpt;
				}
				cpt = 0;
			}
		}

		System.out.println(s);
		return n;
	}

	public int solutionAlgo(int N) {
		int n = 0;
		int cpt = 0;
		boolean demare = false;
		while (N > 0) {
			int reste = N % 2;
			if (reste == 1) {
				if (!demare) {
					n = 0;
					demare = true;
				} else {
					n = Math.max(n, cpt);
				}
				cpt = 0;
			} else {
				cpt++;
			}
			N = N / 2;
		}
		return n;
	}
}
