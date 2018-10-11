package xyz.codingmentor.team3.registry.api;

import java.util.List;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Daróczi Kristóf
 */
public interface IQueryService {

    List<ContactChannel> getProjectContacts(Long projectId, int offset, int max) throws RepositoryException;

    Long countProjectContacts(Long projectId) throws RepositoryException;

    List<Note> getNotesFromEventsWhichAreDedicatedToClient(Long clientId, int offset, int max) throws RepositoryException;

    Long countNotesFromEventsWhichAreDedicatedToClient(Long clientId) throws RepositoryException;

    List<Client> getClientsWhoHadNoEventsInMonths(int numberofMonth, int offset, int max) throws RepositoryException;

    Long countClientsWhoHadNoEventsInMonths(int numberofMonth) throws RepositoryException;

    List<Project> getProjectsFinishesThisWeek(int offset, int max) throws RepositoryException;

    Long countProjectsFinishesThisWeek() throws RepositoryException;

    List<Client> getClientsWhoHasMoreProjectsThan(Long count, int offset, int max) throws RepositoryException;

    Long countClientsWhoHasMoreProjectsThan(Long quantity) throws RepositoryException;

}
