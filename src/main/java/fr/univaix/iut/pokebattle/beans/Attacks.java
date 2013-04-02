package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = Attacks.FIND_BY_POKE, query = "SELECT at FROM Attacks at WHERE at.Pokemon = :pokemon"),
    @NamedQuery(name = Attacks.COUNT_ATTA, query = "SELECT COUNT(at.Attack) FROM Attacks at WHERE at.Pokemon = :pokemon"),
    @NamedQuery(name = Attacks.FIND_ALL, query = "SELECT at FROM Attacks at "),
})
public class Attacks implements Serializable{

	private static final long serialVersionUID = 8869596535250990885L;
	
	public static final String FIND_BY_POKE = "findByPoke";
	public static final String COUNT_ATTA = "CountAtta";
	public static final String FIND_ALL = "findAllAttacks";
	
	@Id 
	@OneToOne 
	@JoinColumn( name = "POKEMON")
	private Pokemon Pokemon; 
	
	@Id
	private String Attack;
	private String Niveau;
	private String Puissance;
	
	@Column( name = "PRC")
	private String Precision;
	private String PP;
	
	public Attacks() {
		super();
	}	
	
	public String getPP() {
		return PP;
	}

	public void setPP(String pP) {
		PP = pP;
	}

	public Pokemon getPokemon() {
		return Pokemon;
	}

	public String getAttack() {
		return Attack;
	}

	public String getNiveau() {
		return Niveau;
	}

	public String getPuissance() {
		return Puissance;
	}

	public String getPrecision() {
		return Precision;
	}
}
