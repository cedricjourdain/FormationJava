package cj.metier;

import javax.management.ListenerNotFoundException;

public class Etudiant {

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String metier;

	private Formation formation;
	private ListeCompetence listeCompetence;
	private ListeFormationScolaire listeFormationScolaire;
	private ListeExperience listeExperience;
	
	public Etudiant(int id, String nom, String prenom, String mail, String metier, Formation formation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.metier = metier;
		this.formation = formation;
		listeExperience = new ListeExperience();
		listeCompetence = new ListeCompetence();
		listeFormationScolaire = new ListeFormationScolaire();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListeCompetence getListeCompetence() {
		return listeCompetence;
	}

	public void setListeCompetence(ListeCompetence listeCompetence) {
		this.listeCompetence = listeCompetence;
	}

	public ListeFormationScolaire getListeFormationScolaire() {
		return listeFormationScolaire;
	}

	public void setListeFormationScolaire(ListeFormationScolaire listeFormationScolaire) {
		this.listeFormationScolaire = listeFormationScolaire;
	}

	public ListeExperience getListeExperience() {
		return listeExperience;
	}

	public void setListeExperience(ListeExperience listeExperience) {
		this.listeExperience = listeExperience;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
