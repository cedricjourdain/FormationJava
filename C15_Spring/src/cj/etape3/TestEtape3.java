package cj.etape3;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

public class TestEtape3 {

	@Test
	public void testA() {
		I i = new BTestOK();
		A a = new A(i);
		Assert.assertTrue(a.m());
		I j = new BTestNOK();
		A a2 = new A(j);
		Assert.assertFalse(a2.m());
	}

	@Test
	public void testB() {
		B b = new B();
		Assert.assertTrue(b.q());
	}

	@Test
	public void testB2() {
		B2 b2 = new B2();
		Assert.assertTrue(b2.q());
	}
}
