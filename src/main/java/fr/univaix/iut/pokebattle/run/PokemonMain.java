package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.PokemonFactory;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

            Pokemon ronflex = new Pokemon("Ronflaix");
            ronflex.setType1(Pokemon.Type.NORMAL);
            ronflex.setBaseHP(160);
            ronflex.setAttack(110);
            ronflex.setDefense(65);
            ronflex.setAttackSpecial(65);
            ronflex.setDefenseSpecial(110);
            ronflex.setSpeed(30);

            PokemonFactory.createPoke(ronflex);

            BotRunner.runBot(new PokeBot(), "twitter4j.properties");
        } catch (TUSEException e) {
            LOGGER.error("Erreur sérieuse dans le BotRunner", e);
        }
    }
}
