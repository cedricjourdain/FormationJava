package cj.etape1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestEtape1 {

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

}
