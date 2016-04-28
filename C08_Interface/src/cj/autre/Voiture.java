package cj.autre;

public class Voiture {
	private float reservoir;
	private float qteMaxReservoir;

	public Voiture(float qteMaxReservoir) {
		this.qteMaxReservoir = 0;
		this.qteMaxReservoir = qteMaxReservoir;
	}

	public void prendreEssence(EssenceInterface st){
		reservoir = st.donnerEssenceInterface(qteMaxReservoir - reservoir);
	}

	@Override
	public String toString() {
		return getClass().getName() + " " + reservoir;
	}

}