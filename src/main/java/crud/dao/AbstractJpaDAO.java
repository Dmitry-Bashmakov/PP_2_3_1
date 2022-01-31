package crud.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDAO <T extends Serializable> {
    private Class<T> clazz;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T findOne(final int id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Transactional
    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(final int entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
}