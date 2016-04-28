package cj.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class EcrireDom {

	public static void main(String[] args) {

		EcrireDom d = new EcrireDom();
		d.init();
	}

	public void init(){
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			Element racine = document.createElement("listeEtudiant");
			document.appendChild(racine);
			
			Comment commentaire = document.createComment("Ceci est la liste es étudiants");
			racine.appendChild(commentaire);
			
			for (int i = 0; i < 3; i++) {
				Element form = document.createElement("formation");
				racine.appendChild(form);
				form.setAttribute("id", Integer.toString(i));
				
				for (int j = 0; j < 5; j++) {
					Element etudiant = document.createElement("etudiant");
					form.appendChild(etudiant);
					etudiant.setAttribute("nom", "etudiant"+Integer.toString(j));
					etudiant.setAttribute("prenom", "prenom"+Integer.toString(j));
					etudiant.setAttribute("metier", "metier"+Integer.toString(j));
					etudiant.setAttribute("mail", "mail"+Integer.toString(j)+".gmail.com");
					etudiant.setTextContent("ceci est un exemple : " + i);
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(document);
			StreamResult sortie = new StreamResult(new File("donnees/creEtudiants.xml"));
			
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			transformer.transform(source, sortie);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
