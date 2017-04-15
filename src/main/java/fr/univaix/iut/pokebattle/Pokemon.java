package fr.univaix.iut.pokebattle;

public class Pokemon {
	String nomPoke;
	String criPoke;
	String ownerPoke;
	
	public Pokemon() {
		// TODO Auto-generated constructor stub
	}		
		
	public Pokemon(String nomPoke, String criPoke, String ownerPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
		this.ownerPoke = ownerPoke;
	}

	@Override
	public String toString() {
		return "Pokemon [nomPoke=" + nomPoke + ", criPoke=" + criPoke
				+ ", ownerPoke=" + ownerPoke + "]";
	}

	public String getNomPoke() {
		return nomPoke;
	}
	public String getCriPoke() {
		return criPoke;
	}
	public String getOwnerPoke() {
		return ownerPoke;
	}
	public void setNomPoke(String nomPoke) {
		this.nomPoke = nomPoke;
	}
	public void setCriPoke(String criPoke) {
		this.criPoke = criPoke;
	}
	public void setOwnerPoke(String ownerPoke) {
		this.ownerPoke = ownerPoke;
	}
}
