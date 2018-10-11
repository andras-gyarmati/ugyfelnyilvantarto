package xyz.codingmentor.team3.registry.api;

import java.util.List;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Krisz
 * @param <T>
 */
public interface ICRUDService<T> {

    T createEntity(T entity) throws RepositoryException;

    T getEntityById(Long entityId) throws RepositoryException;

    T updateEntity(T entity) throws RepositoryException;

    void removeEntity(Long entityId) throws RepositoryException;

    List<T> getAllEntity(int offset, int max) throws RepositoryException;

    Long count() throws RepositoryException;

}
