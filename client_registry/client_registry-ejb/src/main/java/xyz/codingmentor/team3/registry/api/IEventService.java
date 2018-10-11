package xyz.codingmentor.team3.registry.api;

import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 */
public interface IEventService {

    void addClientToEvent(Long eventId, Long clientId) throws RepositoryException;

    void addAddresstoEvent(Long eventId, Long addressId) throws RepositoryException;

    void addPersonToNote(Long personId, Long noteId) throws RepositoryException;

    void addNoteToEvent(Long eventId, Long noteId) throws RepositoryException;

    void addInvitationToEvent(Long eventId, Long invitationId) throws RepositoryException;

}
