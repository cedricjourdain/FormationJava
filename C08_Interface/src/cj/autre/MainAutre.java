package cj.autre;

public class MainAutre {

	public static void main(String[] args) {

		MainAutre m = new MainAutre();
		m.init();
	}

	public void init() {
		StationService total = new StationService(10000);
		GrandeSurface auchan = new GrandeSurface(10000);
		Voiture v = new Voiture(40);
		v.prendreEssence(auchan);
		Voiture v1 = new Voiture(60);
		v1.prendreEssence(total);
		System.out.println(v);
		System.out.println(v1);
		System.out.println(total);
		System.out.println(auchan);
		
	}
}
