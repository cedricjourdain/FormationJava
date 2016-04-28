package cj.metier;


public class Experience {

	private String dateExp;
	private String entreprise;
	private String poste;
	private String description;
	private ListeEtudiant listeEtudiant;

	public Experience() {
		dateExp = "";
		entreprise = "";
		poste = "";
		description = "";
		listeEtudiant = new ListeEtudiant();
	}

	public Experience(String dateExp, String entreprise, String poste, String description, ListeEtudiant listeEtudiant) {
		this.dateExp = dateExp;
		this.entreprise = entreprise;
		this.poste = poste;
		this.description = description;
		this.listeEtudiant = listeEtudiant;
	}

	public Experience(String dateExp, String entreprise, String poste, String description) {
		this.dateExp = dateExp;
		this.entreprise = entreprise;
		this.poste = poste;
		this.description = description;
		listeEtudiant = new ListeEtudiant();
	}

	public String getDateExp() {
		return dateExp;
	}

	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public ListeEtudiant getListeEtudiant() {
		return listeEtudiant;
	}

	public void setListeEtudiant(ListeEtudiant listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
