package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDemoCodility {
	DemoCodility demoCodility;
	private long d2;
	private boolean fini;

	@Before
	public void setUp() throws Exception {
		demoCodility = new DemoCodility();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void testNull() {
		int[] a = null;
		assertEquals(-1, demoCodility.solution(a));
	}

	@Test
	public void testVide() {
		int[] a = {};
		assertEquals(-1, demoCodility.solution(a));
	}

	@Test
	public void test1() {
		int[] a = { 0 };
		assertEquals(0, demoCodility.solution(a));
	}

	@Test
	public void test2() {
		int[] a = { 1, 0 };
		assertEquals(0, demoCodility.solution(a));
	}

	@Test
	public void test3OK() {
		int[] a = { -1, 1, -1 };
		assertEquals(0, demoCodility.solution(a));
	}

	@Test
	public void test3NonOK() {
		int[] a = { 5, 1, -1 };
		assertEquals(0, demoCodility.solution(a));
	}

	@Test
	public void testClassique() {
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		assertEquals(1, demoCodility.solution(a));
	}

	@Test
	public void testCharge() {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) ((0.5 - Math.random()) * Math.pow(2, 5));
		}

		int v = solution(a);
		assertEquals(v, demoCodility.solution(a));
	}

	@Test
	public void testTemps() {
		long l0 = System.nanoTime();
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) ((0.5 - Math.random()) * Math.pow(2, 5));
		}

		long l1 = System.nanoTime();
		long d1 = l1 - l0;
		d2 = d1 * 10;
		fini = false;
		int v = solution(a);
		Thread t = new Thread() {

			@Override
			public void run() {
				super.run();
				long l1 = System.nanoTime();
				// for (int i = 0; i < 10; i++) {
				// try {
				// Thread.sleep(100);
				// } catch (InterruptedException e) {
				// }
				// }
				demoCodility.solution(a);
				long l2 = System.nanoTime();
				d2 = l2 - l1;
				fini = true;

			}

			@Override
			public void destroy() {
				super.destroy();
			}
		};
		t.start();
		try {
			Thread.sleep(100);
			if (!fini) {
				t.interrupt();
				System.out.println("interruption");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(d2 <= d1 * 2);
	}

	@Test
	public void test100000() {
		int[] a = new int[100000];
		int indice = (int) (Math.random() * 100000);
		a[indice] = 1;
		int v = solution(a);
		System.out.println("DEB");
		int w = demoCodility.solution(a);
		System.out.println("FIN");
		assertEquals(v, w);
	}

	public int solution(int[] A) {
		int res = -1;
		if (A != null) {
			if (A.length < 4) {
				try {
					for (int i = 0; i < A.length; i++) {
						long s1 = 0;
						long s2 = 0;
						for (int j = 0; j < i; j++) {
							s1 += A[j];
						}
						for (int j = A.length - 1; j > i; j--) {
							s2 += A[j];
						}
						if (s1 == s2) {
							res = i;
							break;
						}
					}
				} catch (Exception e) {
				}
			} else {
				try {
					long s1 = 0;
					long s2 = 0;
					for (int i = 1; i < A.length; i++) {
						s2 += A[i];
					}
					if (s1 == s2) {
						res = 0;
					} else {
						// System.out.println("0"+" "+s1+","+s2);
						for (int i = 1; i < A.length; i++) {
							s1 += A[i - 1];
							if (i == A.length - 1) {
								s2 = 0;
							} else {
								s2 -= A[i];
							}
							if (s1 == s2) {
								res = i;
								break;
							} else {
								// System.out.println(i+" "+s1+","+s2);
							}
						}
					}
				} catch (Exception e) {
				}
			}
		}
		return res;
	}

	public int sol(int[] A) {
		// write your code in Java SE 8
		int res = -1;
		try {
			for (int i = 0; i < A.length; i++) {
				long s1 = 0;
				long s2 = 0;
				for (int j = 0; j < i; j++) {
					s1 += A[j];
				}
				for (int j = A.length - 1; j > i; j--) {
					s2 += A[j];
				}
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
