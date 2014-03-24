package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class PokemonMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMain.class);

    private PokemonMain() {

    }

    private static Map<String, String> createConfigurationMap() throws URISyntaxException {
        String databaseUrl = System.getenv("DATABASE_URL");
        URI dbUri = new URI(databaseUrl);
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

        Map<String, String> props = new HashMap<String, String>();
        props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        props.put("eclipselink.target-database", "PostgreSQL");
        props.put("javax.persistence.jdbc.url", dbUrl);
        props.put("javax.persistence.jdbc.user", username);
        props.put("javax.persistence.jdbc.password", password);
        return props;
    }

    public static void main(String[] args) throws URISyntaxException {
        try {
            Map<String, String> props = createConfigurationMap();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU", props);
            EntityManager em = emf.createEntityManager();

            DAOFactoryJPA.setEntityManager(em);

            DAOPokemon pokemon = DAOFactoryJPA.createDAOPokemon();

            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // On insert

            Pokemon pikachu = new Pokemon("Pikachu");
            pikachu.setType1(Pokemon.Type.ELECTRIC);
            em.persist(pikachu);
            em.getTransaction().commit();

            // On recherche et on l'affiche

           // Pokemon pika = em.find(Pokemon.class, "Pikachu");
           // System.out.println(pika.toString());

            // On delete

            //em.remove(pika);
           // tx.commit();

            em.close();
            emf.close();

            BotRunner.runBot(new PokeBot(), "twitter4j.properties");
        } catch (TUSEException e) {
            LOGGER.error("Erreur sérieuse dans le BotRunner", e);
        }
    }
}
