package CyclicRotation;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCyclicRotation {
	CyclicRotation cyclicRotation;
	private long d2;
	private boolean fini;

	@Before
	public void setUp() throws Exception {
		cyclicRotation = new CyclicRotation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testNull() {
		int[] a = null;
		assertArrayEquals(null, cyclicRotation.solution(a, 3));
	}

	@Test
	public void testVide() {
		int[] a = {};
		int[] b = {};
		assertArrayEquals(b, cyclicRotation.solution(a, 3));
	}

	@Test
	public void test1() {
		int[] a = { 0 };
		int[] b = { 0 };
		assertArrayEquals(b, cyclicRotation.solution(a, 3));
	}

	@Test
	public void test2() {
		int[] a = { 1, 0 };
		int[] b = { 1, 0 };
		assertArrayEquals(b, cyclicRotation.solution(a, 1000));
	}

	@Test
	public void testClassique() {
		int[] a = { 3, 8, 9, 7, 6 };
		int[] b = { 9, 7, 6, 3, 8 };
		assertArrayEquals(b, cyclicRotation.solution(a, 3));
	}

	@Test
	public void testCharge() {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) ((0.5 - Math.random()) * Math.pow(2, 5));
		}
		assertArrayEquals(a, cyclicRotation.solution(a, a.length));
	}
}
