package sommeilreveil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ThreadReveil extends Thread {

	public boolean sortir = false;

	public ThreadReveil() {

	}
	// lis la console et quand on fat entrer on fais un sysout

	@Override
	public void run() {
		InputStreamReader entreStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreStandard);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		while (!sortir) {
			System.out.print("Please press Enter ");
			try {
				resLecture.readLine();
				System.out.println("Wake up every body");
				synchronized (this) {
					notify();
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("FIN DU REVEIL");
		}
	}

	public void setSortir(boolean b) {
		this.sortir = b;
	}

}
