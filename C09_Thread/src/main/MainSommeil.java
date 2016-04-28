package main;

import sommeilreveil.ThreadSommeil;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil m = new MainSommeil();
		m.init();
	}

	private void init() {
		ThreadSommeil tSommeil = new ThreadSommeil(10);
		tSommeil.start();
	}

}
