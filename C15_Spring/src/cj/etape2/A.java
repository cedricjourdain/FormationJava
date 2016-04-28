package cj.etape2;

public class A {

	private I i;

	public A() {
		this.i = new B();
	}

	public boolean m() {
		return this.i.q();
	}
}
