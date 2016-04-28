package cj.etape1;

public class A {

	private B b;
	
	public A(){
		this.b = new B();
	}
	
	public boolean m(){
		boolean retour = false;
		retour = this.b.q();
		return retour;
	}
}
