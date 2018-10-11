package xyz.codingmentor.team3.registry.rest.query;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.IQueryResource;
import xyz.codingmentor.team3.registry.api.IQueryService;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;
import xyz.codingmentor.team3.registry.dto.contactchannel.ContactChannelDTO;
import xyz.codingmentor.team3.registry.dto.note.NoteDTO;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author Tibor Kun
 */
@Path("/query")
public class QueryResource implements IQueryResource {

    private IQueryService queryService;

    @Inject
    @BuilderQualifier(EntityModel.CONTACTCHANNEL)
    private IBuilder<ContactChannelDTO, ContactChannel> contactChannelbuilder;

    @Inject
    @BuilderQualifier(EntityModel.NOTE)
    private IBuilder<NoteDTO, Note> notebuilder;

    @Inject
    @BuilderQualifier(EntityModel.CLIENT)
    private IBuilder<ClientDTO, Client> clientbuilder;

    @Inject
    @BuilderQualifier(EntityModel.PROJECT)
    private IBuilder<ProjectDTO, Project> projectbuilder;

    @Inject
    public QueryResource(IQueryService queryService) {
        this.queryService = queryService;
    }

    public QueryResource() {
        // nothing to initialize
    }

    @Override
    public Response getProjectContacts(Long projectId, int offset, int max) throws RepositoryException {
        return Response.ok(contactChannelbuilder.buildDTOList(queryService.getProjectContacts(projectId, offset, max))).build();
    }

    @Override
    public Response countProjectContacts(Long projectId) throws RepositoryException {
        return Response.ok(queryService.countProjectContacts(projectId)).build();
    }

    @Override
    public Response getNotesFromEventsWhichAreDedicatedToClient(Long clientId, int offset, int max) throws RepositoryException {
        return Response.ok(notebuilder.buildDTOList(queryService.getNotesFromEventsWhichAreDedicatedToClient(clientId, offset, max))).build();
    }

    @Override
    public Response countNotesFromEventsWhichAreDedicatedToClient(Long clientId) throws RepositoryException {
        return Response.ok(queryService.countNotesFromEventsWhichAreDedicatedToClient(clientId)).build();
    }

    @Override
    public Response getClientsWhoHadNoEventsInMonths(int numberofMonth, int offset, int max) throws RepositoryException {
        return Response.ok(clientbuilder.buildDTOList(queryService.getClientsWhoHadNoEventsInMonths(numberofMonth, offset, max))).build();
    }

    @Override
    public Response countClientsWhoHadNoEventsInMonths(int numberofMonth) throws RepositoryException {
        return Response.ok(queryService.countClientsWhoHadNoEventsInMonths(numberofMonth)).build();
    }

    @Override
    public Response getProjectsFinishesThisWeek(int offset, int max) throws RepositoryException {
        return Response.ok(projectbuilder.buildDTOList(queryService.getProjectsFinishesThisWeek(offset, max))).build();
    }

    @Override
    public Response countProjectsFinishesThisWeek() throws RepositoryException {
        return Response.ok(queryService.countProjectsFinishesThisWeek()).build();
    }

    @Override
    public Response getClientsWhoHasMoreProjectsThan(Long count, int offset, int max) throws RepositoryException {
        return Response.ok(clientbuilder.buildDTOList(queryService.getClientsWhoHasMoreProjectsThan(count, offset, max))).build();
    }

    @Override
    public Response countClientsWhoHasMoreProjectsThan(Long quantity) throws RepositoryException {
        return Response.ok(queryService.countClientsWhoHasMoreProjectsThan(quantity)).build();
    }

}
