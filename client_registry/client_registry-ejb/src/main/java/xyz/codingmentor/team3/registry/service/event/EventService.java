package xyz.codingmentor.team3.registry.service.event;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.api.IEventService;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author Tibor Kun
 */
public class EventService implements IEventService {

    @Inject
    @CRUDServiceQualifier(EntityModel.EVENT)
    private ICRUDService<Event> eventCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CLIENT)
    private ICRUDService<Client> clientCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.ADDRESS)
    private ICRUDService<Address> addressCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.PERSON)
    private ICRUDService<Person> personCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.NOTE)
    private ICRUDService<Note> noteCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.INVITATION)
    private ICRUDService<Invitation> invitationCRUDService;

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addClientToEvent(Long eventId, Long clientId) throws RepositoryException {
        Client client = clientCRUDService.getEntityById(clientId);
        Event event = eventCRUDService.getEntityById(eventId);
        if (!client.getEvents().contains(event)) {
            client.getEvents().add(event);
            event.setClient(client);
            eventCRUDService.updateEntity(event);
            clientCRUDService.updateEntity(client);
        }
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addAddresstoEvent(Long eventId, Long addressId) throws RepositoryException {
        Event event = eventCRUDService.getEntityById(eventId);
        Address address = addressCRUDService.getEntityById(addressId);
        event.setAddress(address);
        eventCRUDService.updateEntity(event);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addPersonToNote(Long personId, Long noteId) throws RepositoryException {
        Note note = noteCRUDService.getEntityById(noteId);
        Person person = personCRUDService.getEntityById(personId);
        note.setPerson(person);
        noteCRUDService.updateEntity(note);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addNoteToEvent(Long eventId, Long noteId) throws RepositoryException {
        Note note = noteCRUDService.getEntityById(noteId);
        Event event = eventCRUDService.getEntityById(eventId);
        note.setEvent(event);
        noteCRUDService.updateEntity(note);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addInvitationToEvent(Long eventId, Long invitationId) throws RepositoryException {
        Invitation invitation = invitationCRUDService.getEntityById(invitationId);
        Event event = eventCRUDService.getEntityById(eventId);
        invitation.setEvent(event);
        event.getInvitations().add(invitation);
        invitationCRUDService.updateEntity(invitation);
        eventCRUDService.updateEntity(event);
    }

}
