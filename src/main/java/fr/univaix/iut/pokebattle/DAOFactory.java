package fr.univaix.iut.pokebattle;

public interface DAOFactory {
		public DAOPokemon createDAOPokemon();
		public DAOAttaque createDAOAttaque();
}
