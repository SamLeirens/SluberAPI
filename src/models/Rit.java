package models;

public class Rit {
	
	private Bestuurder bestuurder;
	private String richting;
	private String evenement;
	private int plaats;
	
	public Rit(Bestuurder bestuurder,String richting)
	{
		this.bestuurder = bestuurder;
		this.richting = richting;
	}
	
	public Rit(Bestuurder bestuurder, String richting, String evenement, int plaats) {
		super();
		this.bestuurder = bestuurder;
		this.richting = richting;
		this.evenement = evenement;
		this.plaats = plaats;
	}

	@Override
	public String toString() {
		return "Rit [bestuurder=" + bestuurder + ", richting=" + richting + "]";
	}

	public Bestuurder getBestuurder() {
		return bestuurder;
	}

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

	public int getPlaats() {
		return plaats;
	}

	public void setPlaats(int plaats) {
		this.plaats = plaats;
	}

	public void setBestuurder(Bestuurder bestuurder) {
		this.bestuurder = bestuurder;
	}

	public String getRichting() {
		return richting;
	}
	public void setRichting(String richting) {
		this.richting = richting;
	}

}
