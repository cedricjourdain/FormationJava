package cj.sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cj.metier.Formation;
import cj.metier.ListeFormation;

public class MainSQL {
	public static void main(String[] args) {
		MainSQL m = new MainSQL();
		// m.createEtudiant();
		// m.insertEtudiant();
		m.init();
	}

	public void init() {
		ListeFormation listeFormation = lectureDom();
		insertFormation(listeFormation);
		ListeFormation listeFormation1 = selectFormation();
	}

	private void createEtudiant() {
		Connection con = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";
		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // CHarger le driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * Autre méthode pour charger le driver : Driver monDriver = new
		 * com.mysql.jdbc.Driver() DriverManager.registerDriver(monDriver);
		 */
		/*
		 * Informations Driver Driver driver = "nomdriver"; String urk =
		 * "url de la jdbc"; DriverPropertyInfo[] props =
		 * driver.getPropertyInfo(url, info); ...
		 */

		String urlBDD = "jdbc:mysql://localhost/bbdCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "CREATE TABLE etudiant (id INT NOT NULL PRIMARY KEY," + //
				"nom VARCHAR(30)," + //
				"prenom VARCHAR(30)," + //
				"metier VARCHAR(30)," + //
				"mail VARCHAR(30)" + //
				");";
		try {
			statement = con.createStatement();
			statement.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insertEtudiant() {
		Connection con = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";
		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // CHarger le driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bbdCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "INSERT INTO etudiant (id, nom, prenom, metier, mail) " + //
				"VALUES (0, 'nom', 'prenom', 'metier', 'mail' );";
		try {
			statement = con.createStatement();
			statement.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insertFormation(ListeFormation listeFormation) {
		Connection con = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";
		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Charger le driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bbdCV";

		try {
			con = DriverManager.getConnection(urlBDD, login, password);
			statement = con.createStatement();
			for (int i = 0; i < listeFormation.size(); i++) {
				Formation formation = listeFormation.get(i);
				System.out.println("'" + formation.getDateFormation() + "', '" + formation.getLieuformation() + "', '"
						+ formation.getDomaineFormation() + "'");
				requete = "INSERT INTO formation (dateFormation, lieuFormation, domaineFormation) " + //
						"VALUES ('" + formation.getDateFormation() + "', '" + formation.getLieuformation() + "', '"
						+ formation.getDomaineFormation() + "' );";
				statement.executeUpdate(requete);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ListeFormation selectFormation() {
		ListeFormation listeFormation = new ListeFormation();
		Connection con = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";
		String login = "Active";
		String password = "VDDMichel";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Charger le driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://www.psyeval.fr/bddCV";

		try {
			con = DriverManager.getConnection(urlBDD, login, password);
			statement = con.createStatement();
			requete = "SELECT * FROM formation where dateFormation LIKE '%avril%';"; 
			statement.executeQuery(requete);
			// quand on ne fait pas de modification on utilise executeQuery
			
			res = statement.getResultSet();
			boolean encore = res.first();
			while (encore) {
				String id = res.getString(1);
				String date = res.getString("dateFormation");
				String lieu = res.getString("lieuFormation");
				String domaine = res.getString("domaineFormation");
				Formation formation = new Formation(date, lieu, domaine);
				System.out.println(formation.toString());
				listeFormation.add(formation);
				encore = res.next();
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeFormation;
	}

	public ListeFormation lectureDom() {
		File fLecture = new File("C:/DevFormation/workspace/Project_Cv/WebContent/WEB-INF/xml/formation.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		ListeFormation listeFormation = new ListeFormation();

		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);
			Element racine = document.getDocumentElement();
			NodeList list = racine.getChildNodes();
			int nbList = list.getLength();

			for (int j = 0; j < nbList; j++) {
				if (list.item(j).getNodeType() == Node.ELEMENT_NODE) {
					Element eFormation = (Element) list.item(j);
					NodeList lFormation = eFormation.getChildNodes();

					String dateFormation = eFormation.getAttribute("dateFormation");
					String lieuFormation = eFormation.getAttribute("lieuFormation");
					String domaineFormation = eFormation.getAttribute("domaineFormation");

					String commentaire = eFormation.getTextContent();
					System.out.println(dateFormation + " " + lieuFormation + " " + domaineFormation);
					Formation form = new Formation(dateFormation, lieuFormation, domaineFormation);
					listeFormation.add(form);
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeFormation;
	}

}