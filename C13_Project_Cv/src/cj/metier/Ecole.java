package cj.metier;

public class Ecole {

	private String date;
	private String ecole;
	private String diplome;

	public Ecole(String date, String ecole, String diplome) {
		this.date = date;
		this.ecole = ecole;
		this.diplome = diplome;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

}
