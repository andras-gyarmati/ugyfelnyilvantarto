package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author Daróczi Kristóf
 */
@Path("/projects")
public class ProjectCRUDResource extends GenericCRUDResource<ProjectDTO, Project> {

    public ProjectCRUDResource() {
        super(null, null);
    }

    @Inject
    public ProjectCRUDResource(@CRUDServiceQualifier(EntityModel.PROJECT) ICRUDService<Project> crudService,
            @BuilderQualifier(EntityModel.PROJECT) IBuilder<ProjectDTO, Project> builder) {
        super(crudService, builder);
    }

}
