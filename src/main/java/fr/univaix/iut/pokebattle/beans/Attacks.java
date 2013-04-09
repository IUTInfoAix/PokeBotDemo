package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity @IdClass(AttacksPK.class) 
@NamedQueries({
    @NamedQuery(name = Attacks.FIND_BY_POKE, query = "SELECT at FROM Attacks at WHERE at.poke = :pokemon"),
    @NamedQuery(name = Attacks.COUNT_ATTA, query = "SELECT COUNT(at.attack) FROM Attacks at WHERE at.poke = :pokemon"),
    @NamedQuery(name = Attacks.FIND_ALL, query = "SELECT at FROM Attacks at "),
})
public class Attacks implements Serializable{

	private static final long serialVersionUID = 8869596535250990885L;
	
	public static final String FIND_BY_POKE = "findByPoke";
	public static final String COUNT_ATTA = "CountAtta";
	public static final String FIND_ALL = "findAllAttacks";
	
	@Id 
	@ManyToOne 
	@JoinColumn( name = "POKEMON")
	private Pokemon poke; 
	
	@Id
	private String attack;
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
		return poke;
	}

	public void setPokemon(Pokemon pokemon) {
		poke = pokemon;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String att) {
		attack = att;
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
		result = prime * result + ((attack == null) ? 0 : attack.hashCode());
		result = prime * result + ((Niveau == null) ? 0 : Niveau.hashCode());
		result = prime * result + ((PP == null) ? 0 : PP.hashCode());
		result = prime * result + ((PPMAX == null) ? 0 : PPMAX.hashCode());
		result = prime * result + ((poke == null) ? 0 : poke.hashCode());
		result = prime * result
				+ ((Precision == null) ? 0 : Precision.hashCode());
		result = prime * result
				+ ((Puissance == null) ? 0 : Puissance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Attacks other = (Attacks) obj;
		if (attack == null) {
			if (other.attack != null)
			{
				return false;
			}
		} else if (!attack.equals(other.attack))
			return false;
		if (Niveau == null) {
			if (other.Niveau != null)
			{
				return false;
			}
		} 
		else if (!Niveau.equals(other.Niveau))
		{	
			return false;
		}
		if (PP == null) {
			if (other.PP != null)
			{
				return false;
			}
		} 
		else if (!PP.equals(other.PP))
		{
			return false;
		}
		if (PPMAX == null) {
			if (other.PPMAX != null)
			{
				return false;
			}
		} else if (!PPMAX.equals(other.PPMAX))
		{
			return false;
		}
		if (poke == null) {
			if (other.poke != null)
			{
				return false;
			}
		} else if (!poke.equals(other.poke))
		{
			return false;
		}
		if (Precision == null) {
			if (other.Precision != null)
			{
				return false;
			}
		} else if (!Precision.equals(other.Precision))
		{
			return false;
		}
		if (Puissance == null) {
			if (other.Puissance != null)
			{
				return false;
			}
		} else if (!Puissance.equals(other.Puissance))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Attacks [Pokemon=" + poke.getNom() + ", Attack=" + attack
				+ ", Niveau=" + Niveau + ", Puissance=" + Puissance
				+ ", Precision=" + Precision + ", PP=" + PP + ", PPMAX="
				+ PPMAX + "]";
	}
	
	
	
}
