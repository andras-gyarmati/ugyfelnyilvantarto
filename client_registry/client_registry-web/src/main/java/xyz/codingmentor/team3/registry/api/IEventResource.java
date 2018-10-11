package xyz.codingmentor.team3.registry.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 */
public interface IEventResource {

    @POST
    @Path("/{eventId}/clients/{clientId}")
    Response addClientToEvent(@PathParam("eventId") Long eventId, @PathParam("clientId") Long clientId) throws RepositoryException;

    @POST
    @Path("/{eventId}/addresses/{addressId}")
    Response addAddresstoEvent(@PathParam("eventId") Long eventId, @PathParam("addressId") Long addressId) throws RepositoryException;

    @POST
    @Path("/notes/{noteId}/people/{personId}")
    Response addPersonToNote(@PathParam("personId") Long personId, @PathParam("noteId") Long noteId) throws RepositoryException;

    @POST
    @Path("/{eventId}/notes/{noteId}")
    Response addNoteToEvent(@PathParam("eventId") Long eventId, @PathParam("noteId") Long noteId) throws RepositoryException;

    @POST
    @Path("/{eventId}/invitations/{invitationId}")
    Response addInvitationToEvent(@PathParam("eventId") Long eventId, @PathParam("invitationId") Long invitationId) throws RepositoryException;

}
