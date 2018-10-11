package xyz.codingmentor.team3.registry.service.query;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.team3.registry.api.IQueryService;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun, brianelete, Daróczi Kristóf
 */
@Stateless
public class QueryService implements IQueryService {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<ContactChannel> getProjectContacts(Long projectId, int offset, int max) throws RepositoryException {
        String selectQuery = "SELECT ch FROM Project p INNER JOIN p.client c INNER JOIN c.contactPeople cp INNER JOIN cp.contactChannels ch WHERE p.id = :projectId";
        TypedQuery<ContactChannel> query = entityManager.createQuery(selectQuery, ContactChannel.class);
        query.setParameter("projectId", projectId).setFirstResult(offset).setMaxResults(max);
        return query.getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long countProjectContacts(Long projectId) throws RepositoryException {
        return entityManager
                .createQuery("SELECT COUNT(ch) FROM Project p INNER JOIN p.client c INNER JOIN c.contactPeople cp INNER JOIN cp.contactChannels ch WHERE p.id = :projectId", Long.class)
                .setParameter("projectId", projectId)
                .getSingleResult();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<Note> getNotesFromEventsWhichAreDedicatedToClient(Long clientId, int offset, int max) throws RepositoryException {
        String selectQuery = "SELECT n FROM Note n INNER JOIN n.event ne INNER JOIN ne.client nec WHERE nec.id = :clientId";
        TypedQuery<Note> query = entityManager.createQuery(selectQuery, Note.class);
        query.setParameter("clientId", clientId).setFirstResult(offset).setMaxResults(max);
        return query.getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long countNotesFromEventsWhichAreDedicatedToClient(Long clientId) throws RepositoryException {
        return entityManager
                .createQuery("SELECT COUNT(n) FROM Note n INNER JOIN n.event ne INNER JOIN ne.client nec WHERE nec.id = :clientId", Long.class)
                .setParameter("clientId", clientId)
                .getSingleResult();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<Client> getClientsWhoHadNoEventsInMonths(int numberofMonth, int offset, int max) throws RepositoryException {
        Date monthDate = monthsBeforeNow(numberofMonth);
        String selectQuery = "SELECT c FROM Client c INNER JOIN c.events ce WHERE ce.finishDate < :monthDate";
        TypedQuery<Client> query = entityManager.createQuery(selectQuery, Client.class);
        query.setParameter("monthDate", monthDate).setFirstResult(offset).setMaxResults(max);
        return query.getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long countClientsWhoHadNoEventsInMonths(int numberofMonth) throws RepositoryException {
        Date monthDate = monthsBeforeNow(numberofMonth);
        return entityManager
                .createQuery("SELECT COUNT(c) FROM Client c INNER JOIN c.events ce WHERE ce.finishDate < :monthDate", Long.class)
                .setParameter("monthDate", monthDate)
                .getSingleResult();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<Project> getProjectsFinishesThisWeek(int offset, int max) throws RepositoryException {
        String selectQuery = "SELECT p FROM Project p WHERE p.deadline BETWEEN :now AND :date";
        TypedQuery<Project> query = entityManager.createQuery(selectQuery, Project.class);
        query.setParameter("date", nextSunday()).setFirstResult(offset).setMaxResults(max);
        query.setParameter("now", new Date());
        return query.getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long countProjectsFinishesThisWeek() throws RepositoryException {
        return entityManager
                .createQuery("SELECT COUNT(p) FROM Project p WHERE p.deadline BETWEEN :now AND :date", Long.class)
                .setParameter("date", nextSunday())
                .setParameter("now", new Date())
                .getSingleResult();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public List<Client> getClientsWhoHasMoreProjectsThan(Long count, int offset, int max) throws RepositoryException {
        String selectQuery = "SELECT c FROM Project p INNER JOIN p.client c WHERE c.name LIKE '%Ltd.' GROUP BY c.id HAVING COUNT(p.id) > :count";
        TypedQuery<Client> query = entityManager.createQuery(selectQuery, Client.class);
        query.setParameter("count", count).setFirstResult(offset).setMaxResults(max);
        return query.getResultList();
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public Long countClientsWhoHasMoreProjectsThan(Long quantity) throws RepositoryException {
        return entityManager
                .createQuery("SELECT COUNT(c.id) FROM Client c WHERE c IN(SELECT c FROM Project p INNER JOIN p.client c WHERE c.name LIKE '%Ltd.' GROUP BY c.id HAVING COUNT(p.id) > :quantity)", Long.class)
                .setParameter("quantity", quantity)
                .getSingleResult();
    }

    @RolesAllowed(value = {"ADMIN", "USER"})
    private static Date nextSunday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    @RolesAllowed(value = {"ADMIN", "USER"})
    private static Date monthsBeforeNow(int months) {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.MONTH, -months);
        return pastDate.getTime();
    }

}
