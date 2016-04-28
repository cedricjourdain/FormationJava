package cj.etape4;

public class Factory {

	private boolean res;
	
	public Factory() {
		A a = new A(new B());
		res = a.m();
		System.out.println(res);
	}
	
	public boolean isRes(){
		return res;
	}
	
	public void setRes(boolean res){
		this.res = res;
	}

}
