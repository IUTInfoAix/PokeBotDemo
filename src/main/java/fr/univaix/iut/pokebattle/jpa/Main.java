package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.jpa.Pokemon.Type;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        String databaseUrl = "postgres://uxmkwioofjunwk:-_KhHXYpfh8urU46Nu6l3m6NBA@ec2-54-197-241-96.compute-1.amazonaws.com:5432/d946ute9ed9erl";
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


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU", props);
        EntityManager em = emf.createEntityManager();

        DAOFactoryJPA.setEntityManager(em);

        em.getTransaction().begin();

        Pokemon ronflex = new Pokemon("Ronflaix");
        ronflex.setType1(Type.NORMAL);
        ronflex.setBaseHP(160);
        ronflex.setAttack(110);
        ronflex.setDefense(65);
        ronflex.setAttackSpecial(65);
        ronflex.setDefenseSpecial(110);
        ronflex.setSpeed(30);

        em.persist(ronflex);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}