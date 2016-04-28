package cj.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import cj.metier.marchand.Marchand;
import cj.metier.product.Alimentary;
import cj.metier.product.Consumable;
import cj.metier.product.Product;
import cj.metier.stock.PasStock;
import cj.metier.stock.Stock;
import cj.metier.stock.StockArrayList;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
		// m.save();
		// m.recup();
		File file = new File("donnees/stock.xml");
		m.chargeXml(file);

	}
	
	public void init() {
		Alimentary banana = new Alimentary("Banane", 0.99f, 3.5f);
		Consumable enveloppe = new Consumable("Enveloppe", 0.1f, 50);
		Product fraise = new Alimentary("Fraise", 2.99f, 0.5f);
		Alimentary patate = new Alimentary("Patate", 3.5f, 4.99f);
		Consumable dentifrice = new Consumable("Dentifrice", 5.1f);
		Alimentary banana2 = new Alimentary("Banane", 0.99f, 3.5f);
		Product orange = new Alimentary("orange", 3.5f, 4.99f);

		// Map
		System.out.println("----------Test TreeMap----------");
		TreeMap<String, Product> treeMap = new TreeMap<String, Product>();
		treeMap.put(banana.getNom(), banana);
		treeMap.put(enveloppe.getNom(), enveloppe);
		treeMap.put(fraise.getNom(), fraise);
		treeMap.put(patate.getNom(), patate);
		treeMap.put(dentifrice.getNom(), dentifrice);
		treeMap.put(orange.getNom(), orange);
		if (treeMap.containsKey(banana2.getNom())) {
			rajouteDansFTreeMap(treeMap, banana2);
		}
		System.out.println("------Test Set<Entry< , >>------");
		Set<Entry<String, Product>> set = treeMap.entrySet();
		for (Entry<String, Product> entry : set) {
			System.out.println(entry.getValue());
		}
		// System.exit(0); // Quitte tout
		System.out.println("-------Test Stock/Marchand-------");
		PasStock monStock = new PasStock();
		Marchand marchand = new Marchand();
		// ArrayList<Product> stock = marchand.getStock().getMonStock();
		// ArrayList<Product> stock = new ArrayList<Product>();
		// ArrayList<Product> stock = monStock.getMonStock();
		marchand.getStock().setLimitePrix(150f);
		marchand.getStock().add(banana);
		marchand.getStock().add(enveloppe);
		marchand.getStock().add(fraise);
		marchand.getStock().add(fraise);
		marchand.getStock().add(banana);
		for (int i = 0; i < marchand.getStock().size(); i++) {
			System.out.println(marchand.getStock().get(i));
		}
		System.out.println("marchand.getStock().size() : " + marchand.getStock().size());
		System.out.println(marchand.getStock().contains(banana) + "ATTENTION REPONSE FAUSSE");
		System.out.println("Indice de la banane ds le stock = " + marchand.getStock().indexOf(banana));
		marchand.getStock().remove(banana);

		for (int i = 0; i < marchand.getStock().size(); i++) {
			System.out.println(marchand.getStock().get(i));
		}
		System.out.println("Sum = " + marchand.getStock().calculSomme());
		System.out.println("marchand.getStock().size() : " + marchand.getStock().size());

		Product banana1 = new Alimentary("Banane1", 0.55f, 2f);

		System.out.println("--------------------------------");

		for (int i = 0; i < marchand.getStock().size(); i++) {
			System.out.println(marchand.getStock().get(i));
		}

		System.out.println("banana = banana1 ? :" + banana.equals(banana1));

		System.out.println("-----Test Collection.sort-------");
		Collections.sort(marchand.getMonStock());
		for (Product produit : marchand.getMonStock()) {
			System.out.println(produit);
		}
		System.out.println("----------Test TreeMap----------");
		int[] nb = { 1, 3, 6, 8 };
		String[] sNb = { "un", "trois", "six", "huit" };
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		for (int i = 0; i < sNb.length; i++) {
			map.put(Integer.valueOf(nb[i]), sNb[i]);
		}
		System.out.println("------------Test Set------------");
		Set<Entry<Integer, String>> s = map.entrySet();
		for (Entry<Integer, String> entry : s) {
			Integer index = entry.getKey();
			String string = entry.getValue();
		}
		System.out.println("------Test Polymorphisme--------");
		Product p = new Consumable("C", 45, 3);
		Product p2 = p;
		float toto = p2.getPrice();
		System.out.println("--------------------------------");
	}

	private void rajouteDansFTreeMap(TreeMap<String, Product> treeMap, Product p) {
		Product produit = treeMap.get(p.getNom());
		produit.rajoute(p);
	}

	private void chargeXml(File file) {
		// Créer des Objets à partir d'un fichier XML
		BufferedReader buf = null;
		StockArrayList stock = null;
		try {
			buf = new BufferedReader(new FileReader(file));
			String line = buf.readLine();
			while (line != null) {
				if (line.contains("<StockArrayList ")) {
					String nomStockCharge = extraitAtt(line, "nomDuStock='");
					stock = new StockArrayList();
				} else if (line.contains("<Alimentary ")) {
					String nameCharge = extraitAtt(line, "name='");
					String weightCharge = extraitAtt(line, "weight='");
					String unitaryPriceCharge = extraitAtt(line, "unitaryPrice='");
					float weightC = Float.valueOf(weightCharge).floatValue();
					float unitaryPriceC = Float.valueOf(unitaryPriceCharge).floatValue();
					Alimentary a = new Alimentary(nameCharge, weightC, unitaryPriceC);
					stock.add(a);
				} else if (line.contains("<Consumable ")) {
					String nameCharge = extraitAtt(line, "name='");
					String quantityCharge = extraitAtt(line, "quantity='");
					String unitaryPriceCharge = extraitAtt(line, "unitaryPrice='");
					float quantityC = Float.valueOf(quantityCharge).floatValue();
					int unitaryPriceC = Integer.valueOf(unitaryPriceCharge).intValue();
					Consumable c = new Consumable(nameCharge, quantityC, unitaryPriceC);
					stock.add(c);
				} else if (line.contains("</StockArrayList>")) {
					for (Product produit : stock) {
						System.out.println(produit.toString());
					}
				}
				line = buf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String extraitAtt(String line, String ch) {
		// Extrait la valeur de l'attribut
		String res = "";
		String newLine=line.replace("\"", "'");
				
		int ind0 = newLine.indexOf(ch);
		int ind1 = newLine.indexOf("'", ind0 + ch.length());
		res = newLine.substring(ind0 + ch.length(), ind1);
		return res;
	}

	public void test() {
		StockArrayList b = fillStock();
		File fileStockArrayList = new File("stockArrayList.ser");
		serialization(b, fileStockArrayList);
		StockArrayList c = (StockArrayList) deserialization(fileStockArrayList);
	}

	public void saveMarchand() {
		// SERIALIZATION
		Marchand m = new Marchand("", 0, 0, 200);
		m.setNomMarchand("Gilbert");
		for (int i = 0; i < 10; i++) {
			m.getMonStock().add(new Alimentary("Aliment" + i, 2, i + 1));
			m.getStockFamille().add(new Consumable("Consumable" + i, 2, i + 1));
			m.getStockPrive().add(new Alimentary("Aliment" + i, 2, i + 1));
		}

		File fMarchand = new File("marchand.ser");
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(fMarchand));
			obj.writeObject(m);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void save() {
		// SERIALIZATION
		Alimentary alim = new Alimentary("bannane", 12, 2);
		File fileAlimentaire = new File("alimentaire.ser");
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(fileAlimentaire));
			obj.writeObject(alim);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void serialization(Object o, File file) {
		// SERIALIZATION
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(file));
			obj.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void recup() {
		// DESERIALIZATION d'Alimentaire
		File file = new File("alimentaire.ser");
		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new FileInputStream(file));
			Alimentary alimentaire = (Alimentary) objIn.readObject();
			System.out.println(alimentaire.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recupStock() {	
		// DESERIALIZATION de StockArrayList
		File file = new File("stockArrayList.ser");
		ObjectInputStream objIn = null;
		try {
			objIn = new ObjectInputStream(new FileInputStream(file));
			StockArrayList stock = (StockArrayList) objIn.readObject();
			System.out.println(stock.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object deserialization(File file) {
		// DESERIALIZATION
		ObjectInputStream objIn = null;
		Object obj = null;
		try {
			objIn = new ObjectInputStream(new FileInputStream(file));
			if (obj instanceof Stock) {
				obj = (Stock) objIn.readObject();
			} else if (obj instanceof StockArrayList) {
				obj = (StockArrayList) objIn.readObject();
			} else if (obj instanceof Alimentary) {
				obj = (Alimentary) objIn.readObject();
			} else if (obj instanceof Consumable) {
				obj = (Consumable) objIn.readObject();
			} else {
				System.out.println("Le fichier n'est pas pris en compte");
			}
			System.out.println(obj.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public StockArrayList fillStock() {
		// Crée un stock (avec une arrayList) on constitue une
		// ArrayList<Product> a = new ArrayList<Product>();
		StockArrayList stockArray = new StockArrayList();
		InputStreamReader entreStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreStandard);
		String prodName = null;
		String prodType = null;
		int quantity = 0;
		Float unitaryPrice = 0f, price = 0f, weight = 0f;
		System.out.print("How many item do you wand in your stock ? : ");
		int nbItem = 0;
		int cpt = 0;
		try {
			nbItem = Integer.valueOf(resLecture.readLine());
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (cpt < nbItem) {
			Product prod = null;
			try {
				System.out.print("Product Type ? (Alimentary/Consumable) : ");
				prodType = resLecture.readLine();
				System.out.print("Product name ? : ");
				prodName = resLecture.readLine();
				if (prodType.toLowerCase().equals("alimentary")) {
					System.out.print("weight ? : ");
					weight = Float.valueOf(resLecture.readLine());
					System.out.print("price ? : ");
					price = Float.valueOf(resLecture.readLine());
					prod = new Alimentary(prodName, price, weight);
				} else if (prodType.toLowerCase().equals("consumable")) {
					System.out.print("quantity ? : ");
					quantity = Integer.valueOf(resLecture.readLine());
					System.out.print("price ? : ");
					price = Float.valueOf(resLecture.readLine());
					prod = new Consumable(prodName, unitaryPrice);
				} else {
					System.out.print("Carotte à 100 balles, Attention a ce que tu écrit ! \n");
					prod = new Alimentary("Carotte à 100 balles le kilo", 100f, 1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			stockArray.add(prod);
			cpt++;
		}
		System.out.println("------------Stock------------");
		for (Product product : stockArray) {
			System.out.println(product);
		}
		System.out.println("-----------------------------");

		// SERIALIZATION :
		// File fileStockArrayList = new File("stockArrayList.ser");
		// ObjectOutputStream obj = null;
		// try {
		// obj = new ObjectOutputStream(new
		// FileOutputStream(fileStockArrayList));
		// obj.writeObject(stockArray);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// obj.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		return stockArray;
	}
	
	// quoi qu'il arrive on utilise des get et des set meme dasn al classe elle
	// meme
	// On fait tous nos controle dans les set !!!
	// On accede a nos propriété par les get !
	// Pour les prop qui sont objets on les instancies (on fait un new)
	// && est prioritaire devant le ou ||
}
