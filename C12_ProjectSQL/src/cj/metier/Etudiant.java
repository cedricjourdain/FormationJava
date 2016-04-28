package cj.metier;

public class Etudiant {
	
	private String nom;
	private String prenom;
	private String metier;
	private String mail;
	private Formation formation;
	
	public Etudiant(String nom, String prenom, String metier, String mail){
		this.prenom = prenom;
		this.metier = metier;
		this.mail = mail;
		this.formation = new Formation();
	}
	
	public Etudiant(String nom, String prenom, String metier, String mail, Formation form){
		this.nom = nom;
		this.prenom = prenom;
		this.metier = metier;
		this.mail = mail;
		this.formation = new Formation(form);
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
	public String getMetier() {
		return metier;
	}
	public void setMetier(String metier) {
		this.metier = metier;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
