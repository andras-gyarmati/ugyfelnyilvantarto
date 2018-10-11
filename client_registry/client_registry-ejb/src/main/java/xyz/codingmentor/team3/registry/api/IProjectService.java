package xyz.codingmentor.team3.registry.api;

import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Daróczi Kristóf
 */
public interface IProjectService {

    void addAddressToClient(Long addressId, Long clientId) throws RepositoryException;

    void addContactChannelToPerson(Long contactChannelId, Long personId) throws RepositoryException;

    void addContactPersonToClient(Long contactPersonId, Long clientId) throws RepositoryException;

    void addProjectToClient(Long projectId, Long clientId) throws RepositoryException;

}
