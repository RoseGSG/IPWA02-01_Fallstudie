package require4Testing;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.*;
import java.util.List;

@Dependent // wichtig: Dependent statt ApplicationScoped für generische Klassen
public class _GenericDAO<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("require4TestingPersistenceUnit");

    protected EntityManager em = emf.createEntityManager();

    private Class<T> entityClass;

    public _GenericDAO() {}

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    
    public void delete(T entity) {
        T managed = em.merge(entity);
        em.remove(managed);
    }

    public void update(T entity) {
        em.merge(entity);
    }


    public List<T> findAll() {
        if (entityClass == null) {
            throw new IllegalStateException("entityClass not set");
        }
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                 .getResultList();
    }
}
