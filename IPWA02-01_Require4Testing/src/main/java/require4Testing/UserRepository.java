package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

@ApplicationScoped
public class UserRepository {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("require4TestingPersistenceUnit");

    public Tester findTesterByLoginAndPassword(String login, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Tester t WHERE t.login = :login AND t.password = :password", Tester.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public RequirementEngineer findEngineerByLoginAndPassword(String login, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM RequirementEngineer r WHERE r.login = :login AND r.password = :password", RequirementEngineer.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public Testfallersteller findTestfallerstellerByLoginAndPassword(String login, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Testfallersteller t WHERE t.login = :login AND t.password = :password", Testfallersteller.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public Testmanager findTestmanagerByLoginAndPassword(String login, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Testmanager t WHERE t.login = :login AND t.password = :password", Testmanager.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
