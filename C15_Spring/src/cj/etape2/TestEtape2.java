package cj.etape2;

import org.junit.Test;

import junit.framework.Assert;

public class TestEtape2 {

	@Test
	public void testA() {
		A a = new A();
		Assert.assertTrue(a.m());
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
