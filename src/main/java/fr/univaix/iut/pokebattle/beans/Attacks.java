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
	private String PPMAX;
	
	public String getPPMAX() {
		return PPMAX;
	}

	public void setPPMAX(String pPMAX) {
		PPMAX = pPMAX;
	}

	public Attacks() {
		super();
	}

	public Pokemon getPokemon() {
		return Pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		Pokemon = pokemon;
	}

	public String getAttack() {
		return Attack;
	}

	public void setAttack(String attack) {
		Attack = attack;
	}

	public String getNiveau() {
		return Niveau;
	}

	public void setNiveau(String niveau) {
		Niveau = niveau;
	}

	public String getPuissance() {
		return Puissance;
	}

	public void setPuissance(String puissance) {
		Puissance = puissance;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getPP() {
		return PP;
	}

	public void setPP(String pP) {
		PP = pP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Attack == null) ? 0 : Attack.hashCode());
		result = prime * result + ((Niveau == null) ? 0 : Niveau.hashCode());
		result = prime * result + ((PP == null) ? 0 : PP.hashCode());
		result = prime * result + ((PPMAX == null) ? 0 : PPMAX.hashCode());
		result = prime * result + ((Pokemon == null) ? 0 : Pokemon.hashCode());
		result = prime * result
				+ ((Precision == null) ? 0 : Precision.hashCode());
		result = prime * result
				+ ((Puissance == null) ? 0 : Puissance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attacks other = (Attacks) obj;
		if (Attack == null) {
			if (other.Attack != null)
				return false;
		} else if (!Attack.equals(other.Attack))
			return false;
		if (Niveau == null) {
			if (other.Niveau != null)
				return false;
		} else if (!Niveau.equals(other.Niveau))
			return false;
		if (PP == null) {
			if (other.PP != null)
				return false;
		} else if (!PP.equals(other.PP))
			return false;
		if (PPMAX == null) {
			if (other.PPMAX != null)
				return false;
		} else if (!PPMAX.equals(other.PPMAX))
			return false;
		if (Pokemon == null) {
			if (other.Pokemon != null)
				return false;
		} else if (!Pokemon.equals(other.Pokemon))
			return false;
		if (Precision == null) {
			if (other.Precision != null)
				return false;
		} else if (!Precision.equals(other.Precision))
			return false;
		if (Puissance == null) {
			if (other.Puissance != null)
				return false;
		} else if (!Puissance.equals(other.Puissance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attacks [Pokemon=" + Pokemon.getNom() + ", Attack=" + Attack
				+ ", Niveau=" + Niveau + ", Puissance=" + Puissance
				+ ", Precision=" + Precision + ", PP=" + PP + ", PPMAX="
				+ PPMAX + "]";
	}
	
	
	
}
