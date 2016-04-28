package cj.etape6;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Factory {

	private boolean res;
	
	public Factory() throws Exception {
		
		Properties props = new Properties();
		props.load(new FileInputStream(new File("etape6/Factory.props")));
		
		Package p = this.getClass().getPackage();
		String nomClasse =p.getName()+"."+props.getProperty("implementation_i_class");
		
		Class<?> d = Class.forName(nomClasse);
		// Class.forName permet de creer une instance d'une classe (avec le newInstance) grace au nom de la classe (en string)
		I i =(I) d.newInstance();

		A a = new A(i);
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
