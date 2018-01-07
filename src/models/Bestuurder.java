package models;

public class Bestuurder {
	
	private int id;
	private String naam;
	private String telefoonnr;
	
	public Bestuurder(int id, String naam, String telefoonnr) {
		super();
		this.id = id;
		this.naam = naam;
		this.telefoonnr = telefoonnr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getTelefoonnr() {
		return telefoonnr;
	}
	public void setTelefoonnr(String telefoonnr) {
		this.telefoonnr = telefoonnr;
	}

}
