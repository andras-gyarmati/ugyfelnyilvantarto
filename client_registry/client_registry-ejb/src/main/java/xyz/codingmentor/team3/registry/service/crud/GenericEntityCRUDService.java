package xyz.codingmentor.team3.registry.service.crud;

import java.util.List;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 * @param <T>
 */
public class GenericEntityCRUDService<T> implements ICRUDService<T> {

    private final ICRUDRepository<T> repository;

    public GenericEntityCRUDService(ICRUDRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T createEntity(T entity) throws RepositoryException {
        return repository.persist(entity);
    }

    @Override
    public T getEntityById(Long entityId) throws RepositoryException {
        return repository.find(entityId);
    }

    @Override
    public T updateEntity(T entity) throws RepositoryException {
        return repository.merge(entity);
    }

    @Override
    public void removeEntity(Long entityId) throws RepositoryException {
        repository.remove(entityId);
    }

    @Override
    public List<T> getAllEntity(int offset, int max) throws RepositoryException {
        return repository.getAll(offset, max);
    }

    @Override
    public Long count() throws RepositoryException {
        return repository.count();
    }

}
