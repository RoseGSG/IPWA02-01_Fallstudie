package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

@ApplicationScoped
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Tester findTesterByLoginAndPassword(String login, String password) {
        try {
            return em.createQuery("SELECT t FROM Tester t WHERE t.login = :login AND t.password = :password", Tester.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public RequirementEngineer findEngineerByLoginAndPassword(String login, String password) {
        try {
            return em.createQuery("SELECT r FROM RequirementEngineer r WHERE r.login = :login AND r.password = :password", RequirementEngineer.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
