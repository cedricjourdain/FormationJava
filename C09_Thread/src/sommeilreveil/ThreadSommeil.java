package sommeilreveil;

import java.text.DecimalFormat;

public class ThreadSommeil extends Thread {

	private int nbDereveil;

	public ThreadSommeil(int nbDereveil) {
		this.nbDereveil = nbDereveil;
	}

	@Override
	public void run() {
		ThreadReveil reveil = new ThreadReveil();
		reveil.start();

		long t = System.nanoTime();
		for (int i = 0; i < nbDereveil; i++) {
			System.out.println("hello after le for");

			synchronized (reveil) {
				try {
					System.out.println("hello after le try");
					reveil.wait();
					System.out.println("hello after le wait");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("I slept " + difToString(t, System.nanoTime()));
				t = System.nanoTime();
			}
		}

		reveil.setSortir(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("stop snurfing");
	}

	// Lance le run du thread reveil
	private String difToString(long avant, long apres) {
		double dif = ((double) apres - avant) / 100000;
		DecimalFormat df = new DecimalFormat("####.00");
		return df.format(dif);
	}

}
