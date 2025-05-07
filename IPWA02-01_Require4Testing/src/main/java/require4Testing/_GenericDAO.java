package require4Testing;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.*;
import java.util.List;

@Dependent // wichtig: Dependent statt ApplicationScoped für generische Klassen
public class _GenericDAO<T> {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("require4TestingPersistenceUnit");

    protected EntityManager em = emf.createEntityManager();

    private Class<T> entityClass;

    public _GenericDAO() {}

    @SuppressWarnings("unchecked")
    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = (Class<T>) entityClass;
    }

    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        Object id = getPrimaryKey(entity);
        T managed = em.find(entityClass, id);
        if (managed != null) {
            em.remove(managed);
        }
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        if (entityClass == null) {
            throw new IllegalStateException("entityClass not set");
        }
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                 .getResultList();
    }

    public T findById(Long id) {
        if (entityClass == null || id == null) {
            return null;
        }
        return em.find(entityClass, id);
    }

    public Object getPrimaryKey(T entity) {
        return em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
    }
}
