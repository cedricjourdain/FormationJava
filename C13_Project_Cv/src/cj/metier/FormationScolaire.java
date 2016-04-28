package cj.metier;

public class FormationScolaire {

	private Etudiant etudiant; 
	
	private String date;
	private String diplome;
	private String ecole;

	public FormationScolaire() {
		date = "";
		diplome = "";
		ecole = "";

	}


	public FormationScolaire(Etudiant etudiant, String date, String diplome, String ecole) {
		this.etudiant=etudiant; 
		this.date = date;
		this.diplome = diplome;
		this.ecole = ecole;

	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDiplome() {
		return diplome;
	}


	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}


	public String getEcole() {
		return ecole;
	}


	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	
	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	@Override
	public String toString() {
		return "Formation du " + date + " à " + ecole + " pour " + diplome;
	}
}
