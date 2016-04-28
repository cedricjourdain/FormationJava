package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cj.main.Main;

public class TestJunit {

	Main main;

	@Before
	public void setup() {
		main = new Main();
		String s = main.extraitAtt("<qdgfdjh nom='' qdeu='' >", "nom='");
		assertEquals("", s);
		String s1 = main.extraitAtt("<qdgfdjh nom='b' qdeu='' >", "nom='");
		assertEquals("b", s1);
		String s2 = main.extraitAtt("<qdgfdjh nom='bonjour' qdeu='' >", "nom='");
		assertEquals("bonjour", s2);
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

}
