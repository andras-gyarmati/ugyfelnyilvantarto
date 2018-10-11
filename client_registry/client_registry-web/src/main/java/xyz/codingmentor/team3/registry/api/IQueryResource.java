package xyz.codingmentor.team3.registry.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Tibor Kun
 */
public interface IQueryResource {

    @GET
    @Path("/projectcontacts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getProjectContacts(
            @PathParam("id") Long projectId,
            @QueryParam("offset") int offset,
            @QueryParam("max") int max) throws RepositoryException;

    @GET
    @Path("/projectcontacts/{id}/count")
    @Produces(MediaType.APPLICATION_JSON)
    Response countProjectContacts(@PathParam("id") Long projectId) throws RepositoryException;

    @GET
    @Path("/notesfromclient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getNotesFromEventsWhichAreDedicatedToClient(
            @PathParam("id") Long clientId,
            @QueryParam("offset") int offset,
            @QueryParam("max") int max) throws RepositoryException;

    @GET
    @Path("/notesfromclient/{id}/count")
    @Produces(MediaType.APPLICATION_JSON)
    Response countNotesFromEventsWhichAreDedicatedToClient(@PathParam("id") Long clientId) throws RepositoryException;

    @GET
    @Path("/eventsinmonth/{numberofmonth}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getClientsWhoHadNoEventsInMonths(
            @PathParam("numberofmonth") int numberofMonth,
            @QueryParam("offset") int offset,
            @QueryParam("max") int max) throws RepositoryException;

    @GET
    @Path("/eventsinmonth/{numberofmonth}/count")
    @Produces(MediaType.APPLICATION_JSON)
    Response countClientsWhoHadNoEventsInMonths(@PathParam("numberofmonth") int numberofMonth) throws RepositoryException;

    @GET
    @Path("/projectsthisweek")
    @Produces(MediaType.APPLICATION_JSON)
    Response getProjectsFinishesThisWeek(
            @QueryParam("offset") int offset,
            @QueryParam("max") int max) throws RepositoryException;

    @GET
    @Path("/projectsthisweek/count")
    @Produces(MediaType.APPLICATION_JSON)
    Response countProjectsFinishesThisWeek() throws RepositoryException;

    @GET
    @Path("/moreprojectsthan/{count}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getClientsWhoHasMoreProjectsThan(
            @PathParam("count") Long count,
            @QueryParam("offset") int offset,
            @QueryParam("max") int max) throws RepositoryException;

    @GET
    @Path("/moreprojectsthan/{quantity}/count")
    @Produces(MediaType.APPLICATION_JSON)
    Response countClientsWhoHasMoreProjectsThan(@PathParam("quantity") Long quantity) throws RepositoryException;

}
