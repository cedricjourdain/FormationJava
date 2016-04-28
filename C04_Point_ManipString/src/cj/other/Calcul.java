package cj.other;

public class Calcul {
	public float[] fromPicoToSize(int nbrePicotLar, int nbrePicotLon) {
		float[] tailleLego = new float[2];

		tailleLego[0] = (float) nbrePicotLar * 0.75f;
		tailleLego[1] = (float) nbrePicotLon * 0.75f;

		return tailleLego;
	}

	public float calculDim(int nbrePicot) {
		float taille = nbrePicot * 0.75f;
		return taille;
	}

	public int calculNbPicot(float dim) {
		int valeurDeRetour = -1;
		if (dim > 0) {
			float n = dim / 0.75f;
			int nb = (int) n;
			if (n - nb < 0.5f)
				valeurDeRetour = nb;
			else
				valeurDeRetour = nb + 1;
		}
		return valeurDeRetour;
	}

}
