package cj.other;

public class ExerciceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciceString e = new ExerciceString();
		e.init();
	}

	public void init() {
		// Exercice :
		// 1. Compter le nbre de caractère ds la chaine.
		// 2. Compter le nbre de fois qu'un caractere est present ds la chaine
		// 3. Le comptage d'un mot present dans la chaine
		// 4. Remplacer une partie de la chaine de caractere

		String phrase = "Bonjour Vous, comment allez vous aujourd'hui ? allez vous bien ?";
		System.out.println("Nombre de caractère dans la chaine : " + phrase.length());

		String charRecherche = "o";
		int ind = phrase.indexOf(charRecherche);
		System.out.println("ind = " + ind);
		int cpt = 0;
		while (ind >= 0) {
			cpt++;
			ind = phrase.indexOf(charRecherche, ind + 1);
		}
		System.out.println("Nombre de " + charRecherche + " = " + Integer.toString(cpt));

		// Autre méthode
		cpt = 0;
		char[] tabPhrase = phrase.toCharArray();
		for (int k = 0; k < tabPhrase.length; k++) {
			if (tabPhrase[k] == 'o')
				cpt++;
		}
		System.out.println("Nombre de " + charRecherche + " = " + Integer.toString(cpt));

		String stringSearch = "allez";
		ind = phrase.indexOf(stringSearch);
		cpt = 0;
		while (ind >= 0) {
			cpt++;
			ind = phrase.indexOf(stringSearch, ind + 1);
		}
		System.out.println("Nombre de " + stringSearch + " = " + Integer.toString(cpt));
		System.out.println(phrase);
		phrase = phrase.replace("allez", "come on");
		System.out.println(phrase);

		phrase = phrase.toLowerCase().replace("come on", "autre");

		// .trim() Supprime les espaces en debut et fin de phrase
		String phrase1 = "    Hello mother fucker     ";
		System.out.println(phrase1);
		System.out.println("\"" + phrase1.trim() + "\"");

		System.out.println("----------------------------");
		int val = 45;
		Integer valInteger = new Integer(val);
		valInteger.valueOf(val);
		String chaineDeVal = Integer.toString(val);
		System.out.println(val + 5);
		System.out.println(chaineDeVal + 5);

	}
}
