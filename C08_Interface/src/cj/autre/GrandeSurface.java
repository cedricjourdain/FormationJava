package cj.autre;

public class GrandeSurface implements EssenceInterface{

private float citerne;
	
	public GrandeSurface(float cuve){
		this.citerne=cuve;
	}
	
	@Override
	public float donnerEssenceInterface(float qte) {

		float qteDelivree = qte;
		if(qte> citerne){
			qteDelivree = citerne;
			citerne = 0;
		} else {
			citerne -=qte;
		}
		return qteDelivree;
	}

	public float getCiterne() {
		return citerne;
	}

	public void setCiterne(float citerne) {
		this.citerne = citerne;
	}

	@Override
	public String toString() {
		return getClass().getName() + " " + getCiterne();
	}
}
