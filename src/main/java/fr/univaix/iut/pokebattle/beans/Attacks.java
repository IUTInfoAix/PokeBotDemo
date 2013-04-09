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
	private String niveau;
	private String puissance;
	
	@Column( name = "PRC")
	private String precision;
	private String pP;
	private String pPMAX;
	
	public String getPPMAX() {
		return pPMAX;
	}

	public void setPPMAX(String pPMAXX) {
		pPMAX = pPMAXX;
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
		return niveau;
	}

	public void setNiveau(String niveauu) {
		niveau = niveauu;
	}

	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissancee) {
		puissance = puissancee;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precisionn) {
		precision = precisionn;
	}

	public String getPP() {
		return pP;
	}

	public void setPP(String pPP) {
		pP = pPP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attack == null) ? 0 : attack.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((pP == null) ? 0 : pP.hashCode());
		result = prime * result + ((pPMAX == null) ? 0 : pPMAX.hashCode());
		result = prime * result + ((poke == null) ? 0 : poke.hashCode());
		result = prime * result
				+ ((precision == null) ? 0 : precision.hashCode());
		result = prime * result
				+ ((puissance == null) ? 0 : puissance.hashCode());
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
		{
			return false;
		}
		if (niveau == null) {
			if (other.niveau != null)
			{
				return false;
			}
		} 
		else if (!niveau.equals(other.niveau))
		{	
			return false;
		}
		if (pP == null) {
			if (other.pP != null)
			{
				return false;
			}
		} 
		else if (!pP.equals(other.pP))
		{
			return false;
		}
		if (pPMAX == null) {
			if (other.pPMAX != null)
			{
				return false;
			}
		} else if (!pPMAX.equals(other.pPMAX))
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
		if (precision == null) {
			if (other.precision != null)
			{
				return false;
			}
		} else if (!precision.equals(other.precision))
		{
			return false;
		}
		if (puissance == null) {
			if (other.puissance != null)
			{
				return false;
			}
		} else if (!puissance.equals(other.puissance))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Attacks [Pokemon=" + poke.getNom() + ", Attack=" + attack
				+ ", Niveau=" + niveau + ", Puissance=" + puissance
				+ ", Precision=" + precision + ", PP=" + pP + ", PPMAX="
				+ pPMAX + "]";
	}

}
