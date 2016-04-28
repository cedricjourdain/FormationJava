import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class Flux {

	public static void main(String[] args) {

		Flux flux = new Flux();
		flux.init();
	}

	public void init() {
		File rep = new File("C:/DevFormation/workspace/C5_InputOutput/donnees");
		System.out.println(rep.getAbsolutePath());
		File repCourant = new File("./");
		System.out.println(repCourant.getAbsolutePath());
		File re = new File("../C3_TableauVariable_projetMarchand/src");
		System.out.println(re.getAbsolutePath());
		if (re.isDirectory()) {
			System.out.println("--------------------------------");
			String[] ls = rep.list();
			for (int i = 0; i < ls.length; i++) {
				System.out.println(ls[i]);
			}
		}
		// Exercice
		String path = "C:/DevFormation/workspace/C5_InputOutput/donnees";
		File rep1 = new File(path);
		System.out.println("-----------aff1()---------------");
		aff1();
		System.out.println("-----------aff3()---------------");
		aff3(rep1);
		System.out.println("-------affFichierTxt()----------");
		affFichierTxt(rep1);
		System.out.println("-----------aff2()---------------");
		aff2(rep1);

	}

	public void aff1() {
		// Affiche les fichiers de dossier et d'un sous dossier
		File re = new File("./donnees/");
		File[] lf = re.listFiles();
		for (int i = 0; i < lf.length; i++) {
			File f = lf[i];
			if (lf[i].isFile()) {
				System.out.println(lf[i].getName());
			} else {
				File[] lf2 = f.listFiles();
				for (int j = 0; j < lf2.length; j++) {
					if (!lf2[j].isDirectory()) {
						System.out.println(lf2[j].getName());
					}
				}
			}
		}
	}

	public void aff2(File re) {
		// Affiche les fichiers de dossier et sous dossier recursivement
		File[] lf = re.listFiles();
		for (int i = 0; i < lf.length; i++) {
			File f = lf[i];
			if (lf[i].isFile()) {
				if (lf[i].getAbsolutePath().toLowerCase().endsWith(".txt")) {
					System.out.println(lf[i].getName());
					// FileImageInputStream fi = new
					// FileImageInputStream(lf[i]); //
					// Fichier autre que texte
					FileReader fr = null;
					try {
						fr = new FileReader(lf[i]);
						BufferedReader bIn = new BufferedReader(fr);
						String line = bIn.readLine();
						while (line != null) {
							System.out.println(line);
							line = bIn.readLine();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally{
						try {
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				aff2(lf[i]);
			}
		}
	}

	public void aff3(File re) {
		// Affiche les fichiers de dossier et sous dossier recursivement
		String[] ls = re.list();
		for (int i = 0; i < ls.length; i++) {
			File file = new File(re.getAbsolutePath() + "/" + ls[i]);
			if (file.isFile()) {
				System.out.println(file.getAbsolutePath());
			} else {
				aff3(file);
			}
		}
	}

	public void affFichierTxt(File re) {
		// Affiche les fichiers de dossier et sous dossier recursivement
		String[] ls = re.list();
		for (int i = 0; i < ls.length; i++) {
			File file = new File(re.getAbsolutePath() + "/" + ls[i]);
			if (file.isFile()) {
				if (file.getAbsolutePath().toLowerCase().endsWith(".txt")) {
					System.out.println(file.getAbsolutePath());
				}
			} else {
				affFichierTxt(file);
			}
		}
	}

}
