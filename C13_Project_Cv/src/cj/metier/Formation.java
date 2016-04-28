package cj.metier;

public class Formation {

	private int idFormation;
	private String dateFormation;
	private String lieuFormation;
	private String domaineFormation;

	private ListeEtudiant listeEtudiant;

	public Formation(int idFormation, String dateFormation, String lieuFormation, String domaineFormation) {
		this.idFormation = idFormation;
		this.dateFormation = dateFormation;
		this.lieuFormation = lieuFormation;
		this.domaineFormation = domaineFormation;
		listeEtudiant = new ListeEtudiant();
	}

	public String getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}

	public ListeEtudiant getListeEtudiant() {
		return listeEtudiant;
	}

	public void setListeEtudiant(ListeEtudiant listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
}
