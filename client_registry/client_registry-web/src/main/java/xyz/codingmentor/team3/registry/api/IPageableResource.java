package xyz.codingmentor.team3.registry.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 */
public interface IPageableResource {

    @GET
    @Path("events/offset/{offset}/max/{max}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvent(@PathParam("offset") int offset, @PathParam("max") int max) throws RepositoryException;

}
