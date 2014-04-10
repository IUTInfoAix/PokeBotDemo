package fr.univaix.iut.pokebattle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = Attaque.FIND_ALL, query = "SELECT a FROM Attaque a"),
        @NamedQuery(name = Attaque.FIND_BY_TYPE, query = "SELECT a FROM Attaque a WHERE a.TypeAttaque = :ftype"),
        @NamedQuery(name = Attaque.FIND_BY_NOM, query = "SELECT a FROM Attaque a WHERE a.NomAttaque = :fnom")
})

public class Attaque {

    public static final String FIND_BY_TYPE = "findAttaqueByType";
    public static final String FIND_ALL = "findAllAttaque";
    public static final String FIND_BY_NOM = "findAttaqueByNom";
    
    @Id
    private String NomAttaque;
    
    /* @Enumerated(EnumType.STRING) */
    private String TypeAttaque;
    
    private int Pp;
    private int Puissance;
    private int Precis;
    
    
    public Attaque() {
        // TODO Auto-generated constructor stub
    }
     
	public String getNomAttaque() {
		return NomAttaque;
	}
	public void setNomAttaque(String nomAttaque) {
		NomAttaque = nomAttaque;
	}
	public String getTypeAttaque() {
		return TypeAttaque;
	}
	public void setTypeAttaque(String typeAttaque) {
		TypeAttaque = typeAttaque;
	}
	public int getPp() {
		return Pp;
	}
	public void setPp(int pp) {
		Pp = pp;
	}
	public int getPuissance() {
		return Puissance;
	}
	public void setPuissance(int puissance) {
		Puissance = puissance;
	}
	public int getPrecision() {
		return Precis;
	}
	public void setPrecision(int precision) {
		Precis = precision;
	}
	@Override
	public String toString() {
		return "Attaque [NomAttaque=" + NomAttaque + ", TypeAttaque="
				+ TypeAttaque + ", Pp=" + Pp + ", Puissance=" + Puissance
				+ ", Precision=" + Precis + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((NomAttaque == null) ? 0 : NomAttaque.hashCode());
		result = prime * result + Pp;
		result = prime * result + Precis;
		result = prime * result + Puissance;
		result = prime * result
				+ ((TypeAttaque == null) ? 0 : TypeAttaque.hashCode());
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
		Attaque other = (Attaque) obj;
		if (NomAttaque == null) {
			if (other.NomAttaque != null)
				return false;
		} else if (!NomAttaque.equals(other.NomAttaque))
			return false;
		if (Pp != other.Pp)
			return false;
		if (Precis != other.Precis)
			return false;
		if (Puissance != other.Puissance)
			return false;
		if (TypeAttaque == null) {
			if (other.TypeAttaque != null)
				return false;
		} else if (!TypeAttaque.equals(other.TypeAttaque))
			return false;
		return true;
	}


} // Attaque()
