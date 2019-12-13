package fty.bdd;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

    static String persistenceUnitName = "fty_cities"; // defined in persistence.xml
    static Map<String, String> env = System.getenv();
    static Map<String, Object> configOverrides = new HashMap<String, Object>();
    static EntityManagerFactory entityManagerFactory;
    //@example Pierre
    private static DAO cityDAO;
    private static DAO monumentDAO;
    private static DAO userDAO;

    public static City updateCity() {
        return update(new City(4L, "PaRiS", -1., -2.));
    }

    public static City update(City city) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        city = em.merge(city);
        em.getTransaction().commit();
        return city;
    }

    public static City readCity() {
        EntityManager em = entityManagerFactory.createEntityManager();
        City city = readCity(em, 4L);
        em.close();
        return city;
    }

    public static City readCity(EntityManager em, Long id) {
        return em.find(City.class, id);
    }

    public static City createCityAndUpdate() {
        EntityManager em = entityManagerFactory.createEntityManager();
        City city = new City("Paris", 0, 0.5);
        em.getTransaction().begin();
        em.persist(city);
        city.setLatitude(1000.);
        em.getTransaction().commit();// MAGIC HAPPENS HERE !
        em.close();
        return city;
    }

    public static City createCity() {
        EntityManager em = entityManagerFactory.createEntityManager();
        City city = new City("Atlantis", 0, 0.5);
        city = create(em, city);
        em.close();
        return city;
    }

    public static City create(EntityManager em, City city) {
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        return city;
    }

//    public static Monument createMonument() {
//
//    }
    public static List<City> findAll(int first, int size) {
        return entityManagerFactory.createEntityManager().createNamedQuery("City.findAll", City.class)
                .setFirstResult(first).setMaxResults(size).getResultList();
    }

    public static void main(String[] args) throws IOException {
        for (String envName : env.keySet()) {
            if (envName.contains("DB_USER")) {
                configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("DB_PASS")) {
                configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
            }
            if (envName.contains("DB_URL")) {
                configOverrides.put("javax.persistence.jdbc.url", env.get(envName));
            }
        }
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName, configOverrides);
        //
        System.out.println(createCity());
        System.out.println(updateCity());
        //
        City paris = new City("Paris", 99, 45);
        Monument tourEiffel = new Monument("Tour Eiffel");
        User user = new User("Franck THERY");
        EntityManager em = entityManagerFactory.createEntityManager();
        cityDAO = new CityDAO(em);
        monumentDAO = new MonumentDAO(em);
        userDAO = new UserDAO(em);
        tourEiffel.setCity((City) cityDAO.create(paris));
        tourEiffel.getUsers().add((User) userDAO.create(user));
        System.out.println("Creation d'un monument " + monumentDAO.create(tourEiffel));
        // Acces en utilisant directement leur type
        TypedQuery<City> query = em.createQuery("SELECT c FROM City AS c WHERE c.name=:nameParam", City.class);
        query.setParameter("nameParam", "Paris");
        for (City c : query.getResultList()) {
            System.out.println(c);
        }
        //
        System.out.println(findAll(0,23));
    }
}
