package cj.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LireDom {

	public static void main(String[] args) {
		LireDom d = new LireDom();
		d.lectureDom();

	}

	public void lectureDom() {
		File fLecture = new File("donnees/ListeEtudiant.xml");
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
					String id = eFormation.getAttribute("id");
					
					for (int j = 0; j < lFormation.getLength(); j++) {
						if (lFormation.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element eEtudiant = (Element) lFormation.item(j);
							String nom = eEtudiant.getAttribute("nom");
							String prenom = eEtudiant.getAttribute("prenom");
							String metier = eEtudiant.getAttribute("metier");
							String mail = eEtudiant.getAttribute("mail");
							String commentaire = eEtudiant.getTextContent();
							System.out.println(nom + " " + prenom + " " + mail + " " + metier);
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
}
