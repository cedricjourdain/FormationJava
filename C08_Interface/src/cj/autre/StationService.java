package cj.autre;

public class StationService implements EssenceInterface {

	private float cuve;

	public StationService() {
		cuve = 1000;
	}

	public StationService(float cuve) {
		this.cuve = cuve;
	}

	@Override
	public float donnerEssenceInterface(float qte) {

		float qteDelivree = qte;
		if (qte > cuve) {
			qteDelivree = cuve;
			cuve = 0;
		} else {
			cuve -= qte;
		}
		return qteDelivree;
	}

	public float getCuve() {
		return cuve;
	}

	public void setCuve(float cuve) {
		this.cuve = cuve;
	}

	@Override
	public String toString() {
		return getClass().getName() + " " + getCuve();
	}

}
