package cj;

public class ClassRunnable implements Runnable {

	public void run() {
		System.out.println("Début du run");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Fin du run");

	}
}
