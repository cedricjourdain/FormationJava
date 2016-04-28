package cj.etape7;

public class MainAB {

	public static void main(String[] args) {
		MainAB ab = new MainAB();
		ab.init();
	}

	private void init() {
		I i = new B();
		A a = new A(i);
		a.m();

	}

}
