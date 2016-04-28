package cj.metier;

public class Formation {
	private String nomFormation;
	private String dateFormation;
	private String lieuFormation;
	private String domaineFormation;
	private ListeEtudiant listeEtudiant;

	public Formation() {
		nomFormation = "";
		dateFormation = "";
		lieuFormation = "";
		domaineFormation = "";
		listeEtudiant = new ListeEtudiant();
	}

	public Formation(Formation form) {
		this.dateFormation = form.dateFormation;
		this.lieuFormation = form.lieuFormation;
		this.domaineFormation = form.domaineFormation;
	}
	
	public Formation(String dateFormation, String lieuFormation, String domaineFormation) {
		this.dateFormation = dateFormation;
		this.lieuFormation = lieuFormation;
		this.domaineFormation = domaineFormation;
		listeEtudiant = new ListeEtudiant();
	}

	public Formation(String dateFormation, String lieuFormation, String domaineFormation,ListeEtudiant listeEtudiant) {
		this.dateFormation = dateFormation;
		this.lieuFormation = lieuFormation;
		this.domaineFormation = domaineFormation;
		this.listeEtudiant = listeEtudiant;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public ListeEtudiant getListeEtudiant() {
		return listeEtudiant;
	}

	public void setListeEtudiant(ListeEtudiant listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}

	public String getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}

	public String getLieuformation() {
		return lieuFormation;
	}

	public void setLieuformation(String lieuformation) {
		this.lieuFormation = lieuformation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}

	@Override
	public String toString() {
		return "Formation : " + domaineFormation + " à " + lieuFormation + " pendant la période " + dateFormation;
	}

}
