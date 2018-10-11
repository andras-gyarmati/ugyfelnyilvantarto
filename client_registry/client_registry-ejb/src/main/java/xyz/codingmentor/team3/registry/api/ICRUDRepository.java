package xyz.codingmentor.team3.registry.api;

import java.util.List;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Krisz
 * @param <T>
 */
public interface ICRUDRepository<T> {

    T persist(T entity) throws RepositoryException;

    T find(Long entityId) throws RepositoryException;

    T merge(T entity) throws RepositoryException;

    void remove(Long entityId) throws RepositoryException;

    List<T> getAll(int offset, int max) throws RepositoryException;

    Long count() throws RepositoryException;

}
