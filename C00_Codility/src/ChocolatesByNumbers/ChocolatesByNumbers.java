package ChocolatesByNumbers;

import java.util.ArrayList;

public class ChocolatesByNumbers {

	public static void main(String[] args) {

		ChocolatesByNumbers test = new ChocolatesByNumbers();
		int N = 10;
		int M = 4;
		System.out.println(test.solution(N, M));
	}

	public int solution(int N, int M) {
		boolean empty = false;
		ArrayList<Integer> chocolateEat = new ArrayList<>();

		int i = 0;
		while (!empty && i < N) {

			if (!chocolateEat.contains(i)) {
				chocolateEat.add(i);
			} else
				empty = true;
			i = (i + M) % N;
		}
		return chocolateEat.size();
	}

}
