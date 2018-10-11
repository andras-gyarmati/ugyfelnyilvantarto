package xyz.codingmentor.team3.registry.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Daróczi Kristóf
 */
public interface IProjectResource {

    @POST
    @Path("/addresses/{addressId}/clients/{clientId}")
    public Response addAddressToClient(@PathParam("addressId") Long addressId, @PathParam("clientId") Long clientId) throws RepositoryException;

    @POST
    @Path("/contatchannels/{contactChannelId}/people/{personId}")
    public Response addContactChannelToPerson(@PathParam("contactChannelId") Long contactChannelId, @PathParam("personId") Long personId) throws RepositoryException;

    @POST
    @Path("/contactpeople/{contactPersonId}/clients/{clientId}")
    public Response addContactPersonToClient(@PathParam("contactPersonId") Long contactPersonId, @PathParam("clientId") Long clientId) throws RepositoryException;

    @POST
    @Path("/{projectId}/clients/{clientId}")
    public Response addProjectToClient(@PathParam("projectId") Long projectId, @PathParam("clientId") Long clientId) throws RepositoryException;

}
