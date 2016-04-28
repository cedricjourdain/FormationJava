package cj.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cj.metier.Competence;
import cj.metier.Etudiant;
import cj.metier.Experience;
import cj.metier.Formation;
import cj.metier.FormationScolaire;
import cj.metier.ListeEtudiant;
import cj.metier.ListeFormation;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ServletListeFormation")
public class ServletListeFormation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeFormation() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * travail fait dans un premier temps HttpSession session =
		 * request.getSession(); File fFormation = new File(
		 * "../workspace/C13_Project_Cv/WebContent/WEB-INF/xml/formation.xml");
		 * listeFormation = chargeListeFormationXml(fFormation);
		 * session.setAttribute("listeForm", listeFormation);
		 * 
		 * File fEtudiant = new File(
		 * "../workspace/C13_Project_Cv/WebContent/WEB-INF/xml/ListeEtudiant.xml"
		 * ); chargeListeEtudiant(fEtudiant);
		 * 
		 * PrintWriter out = response.getWriter(); // créer un flux de sortie
		 * File f = new File(
		 * "../workspace/C13_Project_Cv/WebContent/WEB-INF/page/pageListeFormation.html"
		 * ); chargeListeFormationToHtml(f, out); // charger la page html à
		 * afficher
		 */

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter(); // créer un flux de sortie
		File f = new File("../workspace/C13_Project_Cv/WebContent/WEB-INF/page/pageListeFormation.html");
		ListeFormation listeFormation = chargerListeFormationSQL();
		session.setAttribute("listeFormation", listeFormation);
		chargeListeFormationOnHtml(listeFormation, f, out); // charger la page
															// html à afficher
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		ListeFormation listeFormation = (ListeFormation) session.getAttribute("listeFormation");

		String sIdFormation = req.getParameter("bFormation");
		System.out.println(sIdFormation);
		int idFormation = Integer.valueOf(sIdFormation).intValue();
		Formation formation = listeFormation.get(idFormation);

		if (idFormation >= 0 && idFormation < listeFormation.size()) {
			ListeEtudiant listeEtudiant = formation.getListeEtudiant();
			PrintWriter out = resp.getWriter(); // créer un flux de sortie
			File f = new File("../workspace/C13_Project_Cv/WebContent/WEB-INF/page/pageListeEtudiant.html");
			chargeListeEtudiantToHtlm(f, out, listeEtudiant);
		} else {

		}

		session.setAttribute("formation", formation);

	}

	private ListeFormation chargerListeFormationSQL() {
		/*
		 * Charge la liste des formations d'activ Consult'ing à partir de SQL
		 * puis charge la liste des Etudiants de la formation selectionné
		 */
		ListeFormation listeFormation = new ListeFormation();
		Connection con = null;
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			String login = "Active";
			String password = "VDDMichel";
			// connection à la base de données
			String dBurl = "jdbc:mysql://www.psyeval.fr/bddCV";
			con = DriverManager.getConnection(dBurl, login, password);
			stmt = con.createStatement();
			requete = "SELECT * FROM formation";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("idFormation");
				String date = set.getString("dateFormation");
				String lieu = set.getString("lieuFormation");
				String domaine = set.getString("domaineFormation");
				System.out.println(date + " " + lieu + " " + domaine);
				Formation formation = new Formation(id, date, lieu, domaine);
				listeFormation.add(formation);
				chargerListeEtudiantSQL(formation, con);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeFormation;
	}

	private void chargerListeEtudiantSQL(Formation formation, Connection con) {
		/*
		 * Charge la liste des etudiants de la formation choisi à partir de SQL
		 * puis charge la liste des competences des etudiants de la liste des
		 * formations d'Activ consult'ing selectionné
		 */
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM etudiant WHERE idFormation =" + formation.getIdFormation();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String nom = set.getString("nom");
				String prenom = set.getString("prenom");
				String mail = set.getString("mail");
				String metier = set.getString("metier");
				Etudiant etudiant = new Etudiant(id, nom, prenom, mail, metier, formation);
				formation.getListeEtudiant().add(etudiant);
				chargeListeComptentenceSQL(etudiant, con);
				chargeListeExperienceSQL(etudiant, con);
				chargeListeFormationScolaireSQL(etudiant, con);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeComptentenceSQL(Etudiant etudiant, Connection con) {
		// Charge la liste des compétences de l'étudiant selectionné
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM competence WHERE idEtudiant =" + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				String type = set.getString("type");
				String detail = set.getString("detail");
				String niveau = set.getString("niveau");
				String idEtudiant = set.getString("idEtudiant");
				Competence competence = new Competence(idEtudiant, type, detail, niveau);
				etudiant.getListeCompetence().add(competence);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeExperienceSQL(Etudiant etudiant, Connection con) {
		// Charge la liste des experiences de l'étudiant selectionné
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM experience WHERE idEtudiant =" + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				String dateExp = set.getString("dateExp");
				String entreprise = set.getString("entreprise");
				String poste = set.getString("poste");
				String description = set.getString("description");
				Experience experience = new Experience(dateExp, entreprise, poste, description);
				etudiant.getListeExperience().add(experience);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeFormationScolaireSQL(Etudiant etudiant, Connection con) {
		// Charge la liste des formation scolaire de l'étudiant selectionné
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM formation_scolaire WHERE idEtudiant =" + etudiant.getId();
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				String date = set.getString("date");
				String diplome = set.getString("diplome");
				String ecole = set.getString("ecole");
				FormationScolaire formationScolaire = new FormationScolaire(etudiant, date, diplome, ecole);
				etudiant.getListeFormationScolaire().add(formationScolaire);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chargeListeEtudiantToHtlm(File file, PrintWriter out, ListeEtudiant listeEtudiant) {
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String line = buf.readLine();
			while (line != null) {
				if (line.contains("%%nom%%") || line.contains("%%prenom%%") || line.contains("%%metier%%")
						|| line.contains("%%mail%%") || line.contains("%%name%%") || line.contains("%%valeur%%")) {
					int cpt = 0;
					for (Etudiant etudiant : listeEtudiant) {
						String ligneAAfficher = line;
						ligneAAfficher = ligneAAfficher.replace("%%name%%", "bEtudiant");
						ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(cpt));
						ligneAAfficher = ligneAAfficher.replace("%%nom%%", etudiant.getNom());
						ligneAAfficher = ligneAAfficher.replace("%%prenom%%", etudiant.getPrenom());
						ligneAAfficher = ligneAAfficher.replace("%%metier%%", etudiant.getMetier());
						ligneAAfficher = ligneAAfficher.replace("%%mail%%", etudiant.getMail());
						out.println(ligneAAfficher);
						cpt++;
					}
				} else {
					out.println(line);
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

	private void chargeListeFormationOnHtml(ListeFormation listeFormation, File file, PrintWriter out) {
		// Créer des Objets à partir d'un fichier HTML
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new FileReader(file.getAbsolutePath()));
			System.out.println(file.getAbsolutePath());
			String line = buf.readLine();
			while (line != null) {
				if (line.contains("%%date%%") || line.contains("%%lieu%%") || line.contains("%%domaine%%")
						|| line.contains("%%name%%") || line.contains("%%valeur%%")) {
					int cpt = 0;
					for (Formation formation : listeFormation) {
						String ligneAAfficher = line;
						ligneAAfficher = ligneAAfficher.replace("%%name%%", "bFormation");
						ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(cpt));
						ligneAAfficher = ligneAAfficher.replace("%%date%%", formation.getDateFormation());
						ligneAAfficher = ligneAAfficher.replace("%%lieu%%", formation.getLieuFormation());
						ligneAAfficher = ligneAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
						out.println(ligneAAfficher);
						cpt++;
					}
				} else {
					out.println(line);
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

	public void chargeListeEtudiant(File fLecture, ListeFormation listeFormation) {
		ListeEtudiant listeEtudiant = null;
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);
			Element racine = document.getDocumentElement();
			NodeList list = racine.getChildNodes();
			int nbList = list.getLength();

			for (int i = 0; i < nbList; i++) {
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eFormation = (Element) list.item(i);
					NodeList lFormation = eFormation.getChildNodes();
					String sId = eFormation.getAttribute("id");
					Formation form = listeFormation.get(Integer.valueOf(sId).intValue());
					for (int j = 0; j < lFormation.getLength(); j++) {
						if (lFormation.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element eEtudiant = (Element) lFormation.item(j);
							String nom = eEtudiant.getAttribute("nom");
							int id = Integer.valueOf(eEtudiant.getAttribute("id")).intValue();
							String prenom = eEtudiant.getAttribute("prenom");
							String metier = eEtudiant.getAttribute("metier");
							String mail = eEtudiant.getAttribute("mail");
							String commentaire = eEtudiant.getTextContent();
							String sCv = eEtudiant.getAttribute("cv");
							System.out.println(nom + " " + prenom + " " + mail + sCv + metier);
							Etudiant e = new Etudiant(id, nom, prenom, metier, mail, form);
							listeEtudiant = form.getListeEtudiant();
							listeEtudiant.add(e);
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ListeFormation chargeListeFormationXml(File file) {
		/*
		 * Créer une liste de formation à partir d'un fichier XML
		 */
		BufferedReader buf = null;
		ListeFormation listeFormation = new ListeFormation();
		try {
			buf = new BufferedReader(new FileReader(file.getAbsolutePath()));
			System.out.println(file.getAbsolutePath());
			String line = buf.readLine();
			while (line != null) {
				if (line.contains("<ListeFormation>")) {
					listeFormation = new ListeFormation();
				} else if (line.contains("<Formation ")) {
					String sIdFormation = extraitAtt(line, "idFormation='");
					int IdFormation = Integer.valueOf(sIdFormation).intValue();
					String dateFormation = extraitAtt(line, "dateFormation='");
					String lieuFormation = extraitAtt(line, "lieuFormation='");
					String domaineFormation = extraitAtt(line, "domaineFormation='");
					Formation a = new Formation(IdFormation, dateFormation, lieuFormation, domaineFormation);
					listeFormation.add(a);
				} else if (line.contains("</ListeFormation>")) {
					for (Formation formation : listeFormation) {
						System.out.println(formation.toString());
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
		return listeFormation;
	}

	public String extraitAtt(String line, String ch) {
		/*
		 * Extrait les attributs d'une ligne d'un fichier XML, cette ligne
		 * contient obligatoirement des attributs.
		 */
		String res = "";
		String newLine = line.replace("\"", "'");
		int ind0 = newLine.indexOf(ch);
		int ind1 = newLine.indexOf("'", ind0 + ch.length());
		res = newLine.substring(ind0 + ch.length(), ind1);
		return res;
	}

}