package xyz.codingmentor.team3.registry.rest.project;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IProjectResource;
import xyz.codingmentor.team3.registry.api.IProjectService;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author Daróczi Kristóf
 */
@Path("/projects")
public class ProjectResource implements IProjectResource {

    @Inject
    private IProjectService projectService;

    public ProjectResource() {
        //empty on purpose
    }

    @Override
    public Response addAddressToClient(Long addressId, Long clientId) throws RepositoryException {
        projectService.addAddressToClient(addressId, clientId);
        return Response.ok().build();
    }

    @Override
    public Response addContactChannelToPerson(Long contactChannelId, Long personId) throws RepositoryException {
        projectService.addContactChannelToPerson(contactChannelId, personId);
        return Response.ok().build();
    }

    @Override
    public Response addContactPersonToClient(Long contactPersonId, Long clientId) throws RepositoryException {
        projectService.addContactPersonToClient(contactPersonId, clientId);
        return Response.ok().build();
    }

    @Override
    public Response addProjectToClient(Long projectId, Long clientId) throws RepositoryException {
        projectService.addProjectToClient(projectId, clientId);
        return Response.ok().build();
    }

}
