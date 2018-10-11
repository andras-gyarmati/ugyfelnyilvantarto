package xyz.codingmentor.team3.registry.rest.event;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IEventResource;
import xyz.codingmentor.team3.registry.api.IEventService;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 */
@Path("/events")
public class EventResource implements IEventResource {

    private IEventService eventService;

    public EventResource() {
        //nothing to initialize
    }

    @Inject
    public EventResource(IEventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public Response addClientToEvent(Long eventId, Long clientId) throws RepositoryException {
        eventService.addClientToEvent(eventId, clientId);
        return Response.ok().build();
    }

    @Override
    public Response addAddresstoEvent(Long eventId, Long addressId) throws RepositoryException {
        eventService.addAddresstoEvent(eventId, addressId);
        return Response.ok().build();
    }

    @Override
    public Response addPersonToNote(Long personId, Long noteId) throws RepositoryException {
        eventService.addPersonToNote(personId, noteId);
        return Response.ok().build();
    }

    @Override
    public Response addNoteToEvent(Long eventId, Long noteId) throws RepositoryException {
        eventService.addNoteToEvent(eventId, noteId);
        return Response.ok().build();
    }

    @Override
    public Response addInvitationToEvent(Long eventId, Long invitationId) throws RepositoryException {
        eventService.addInvitationToEvent(eventId, invitationId);
        return Response.ok().build();
    }

}
