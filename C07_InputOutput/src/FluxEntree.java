import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class FluxEntree {

	public static void main(String[] args) {
		FluxEntree f = new FluxEntree();
		f.init();

	}

	public void init() {
		System.out.print("Repository name ? : ");
		InputStreamReader entreStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreStandard);
		String s = null;
		PrintWriter out = null;
		try {
			s = resLecture.readLine();
			File rootRepository = new File("./" + s);
			File f = new File("./test.txt");
			out = new PrintWriter(f);

			out.println(f.getAbsolutePath());
			System.out.println(f.getAbsolutePath());
			writeTxtFile(f, rootRepository, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();

		String chemin = null;
		PrintWriter out1 = null;

		try {
			chemin = resLecture.readLine();
			File file = new File(chemin);
			File resultat = new File("./test1.txt");
			System.out.println(resultat.getAbsolutePath());
			out1 = new PrintWriter(resultat);

			if (file.exists()) {
				if (file.isDirectory()) {
					System.out.println(file.getAbsolutePath());
					System.out.println("C'est un répertoire et il existe, je peux commencer ma recherche");
					String nomDuSuffixe = resLecture.readLine();
					System.out.println(nomDuSuffixe);
					rechercherLesFichiers(chemin, nomDuSuffixe, out1);
				} else {
					System.out.println("c'est un fichier, je  ne peux pas commencer mon programme (erreur)");
				}
			} else {
				System.out.println("Le fichier ou repertoire n'existe pas je ne peux pas commencer");
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.close();
		// Sur la consol on va ecrire le chemin d'un repertoire
		// a la deuxieme ligne on va lire le type de fichier
		// lire le repertoire correspondant et ceux de l'iinterieur
		// pour lire l'ensemble es fichiers qu'ils contiennent
		// écrire l'ensemble des chaine de caractere trouvé les fichiers txt
		// dans un fichier txt que l'on crée à ./donnees
	}

	private void rechercherLesFichiers(String path, String nomDuSuffixe, PrintWriter out) {
		File file = new File(path);
		File[] tabFichier = file.listFiles();
		for (File f : tabFichier) {
			if (f.isDirectory()) {
				rechercherLesFichiers(f.getAbsolutePath(), nomDuSuffixe, out);
			} else {
				if (f.getName().toLowerCase().endsWith(nomDuSuffixe.toLowerCase())) {
					System.out.println("j'ai trouvé ce fichier : " + f.getName());
					FileReader reader = null;
					try {
						reader = new FileReader(f);
						BufferedReader buf = new BufferedReader(reader);
						String chaine = buf.readLine();
						while (chaine != null) {
							WriteLine(chaine, out);
							chaine = buf.readLine();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					out.flush();
				}
			}
		}
	}

	public void WriteLine(String chaine, PrintWriter out) {
		out.println(chaine);
	}

	public void writeTxtFile(File writableFile, File rootRepository, PrintWriter out) {
		// Ecrit le contenu des fichiers .txt contenu dans le "rootRepository"
		// dans un fichier txt (writableFile)
		String[] ls = rootRepository.list();

		for (int i = 0; i < ls.length; i++) {
			File file = new File(rootRepository.getAbsolutePath() + "/" + ls[i]);
			if (file.isFile()) {
				if (file.getAbsolutePath().toLowerCase().endsWith(".txt")) {
					out.println(file.getAbsolutePath());

					FileReader fr = null;
					try {
						fr = new FileReader(file);
						BufferedReader bIn = new BufferedReader(fr);
						String line = bIn.readLine();
						while (line != null) {
							out.println(line);
							line = bIn.readLine();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				writeTxtFile(writableFile, file, out);
			}
		}
	}
}
