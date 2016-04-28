package cj.other;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestString testString = new TestString();
		testString.init();

	}

	public void init() {
		String s1 = "Mon premier String";
		String s2 = "Mon premier String";
		int lng = s1.length();
		int lng1 = "Mon premier String".length();
		boolean b1 = s1.equals("Mon premier String");
		int comp1 = "A".compareTo("a");
		System.out.println(comp1);
		char[] tab = s1.toCharArray();
		System.out.println(tab);
		int majuscule = 'A';
		int minuscule = 'a';
		System.out.println(majuscule + " " + minuscule + " " + (majuscule - minuscule));
		System.out.println(s1.toUpperCase().replace("PRE", "PER").substring(3, 7));
		s1 = s1.replace("String", "coucou");
		if (s1.contains("PER")) {
			System.out.println("Contenu !");
		} else {
			System.out.println("Non contenu !");
		}
		int ind1 = s1.indexOf("c");
		int ind2 = s1.lastIndexOf("c");
		System.out.println(ind1+" "+ind2);
		byte[] b = s1.getBytes();
		System.out.println(b.length);
		System.out.println(s1.substring(4,11));
		
		int i = Integer.valueOf("257").intValue();
		System.out.println(i);
		String sI = Integer.toString(i);
		System.out.println(sI);
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toBinaryString(i));
		int j = new Integer(5).intValue();
		
		//int k = Integer.valueOf("aaaaa");
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		int a =4;
		System.out.println(a);
		if (i1.equals(i2)){
			System.out.println("perdu");
		}
		else{
			System.out.println("Gagné");
		}
		
		
	}
}
