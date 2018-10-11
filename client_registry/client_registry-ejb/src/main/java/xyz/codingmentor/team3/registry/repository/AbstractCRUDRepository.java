package xyz.codingmentor.team3.registry.repository;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.log.LoggingInterceptor;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;

/**
 *
 * @author Tibor Kun
 * @param <T>
 */
@Interceptors(LoggingInterceptor.class)
public abstract class AbstractCRUDRepository<T> implements ICRUDRepository<T> {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    private final String getAllquery;
    private final String counterQuery;

    public AbstractCRUDRepository(String getAllquery, String counterQuery) {
        this.getAllquery = getAllquery;
        this.counterQuery = counterQuery;
    }

    @Override
    @Interceptors(ValidatorInterceptor.class)
    @RolesAllowed(value = {"ADMIN", "USER"})
    public T persist(T entity) throws RepositoryException {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public T find(Long entityId) throws RepositoryException {
        return getEntityManager().find(getEntityClass(), entityId);
    }

    @Override
    @Interceptors(ValidatorInterceptor.class)
    @RolesAllowed(value = {"ADMIN", "USER"})
    public T merge(T entity) throws RepositoryException {
        return getEntityManager().merge(entity);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void remove(Long entityId) throws RepositoryException {
        getEntityManager().remove(find(entityId));
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<T> getAll(int offset, int max) throws RepositoryException {
        return entityManager
                .createNamedQuery(getAllquery)
                .setFirstResult(offset)
                .setMaxResults(max)
                .getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long count() throws RepositoryException {
        return entityManager.createNamedQuery(counterQuery, Long.class).
                getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public String getGetAllquery() {
        return getAllquery;
    }

    public String getCounterQuery() {
        return counterQuery;
    }

    protected abstract Class<T> getEntityClass();

}
