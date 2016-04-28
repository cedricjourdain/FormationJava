package cj;

public class MaClassRun {

	public static void main(String[] args) {
		MaClassRun test = new MaClassRun();
		test.init();
	}

	public void init() {
		for (int i = 0; i < 10; i++) {
			ClassRunnable c = new ClassRunnable();
			Thread toto = new Thread(c);
			toto.start();
		}
	}

}
