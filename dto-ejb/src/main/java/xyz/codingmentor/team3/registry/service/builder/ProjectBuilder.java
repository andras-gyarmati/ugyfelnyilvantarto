package xyz.codingmentor.team3.registry.service.builder;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.PROJECT)
public class ProjectBuilder implements IBuilder<ProjectDTO, Project> {

    @Inject
    @CRUDServiceQualifier(EntityModel.CLIENT)
    ICRUDService<Client> clientCRUDService;

    @Override
    public Project buildEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setProjectName(dto.getProjectName());
        project.setDeadline(dto.getDeadline());
        project.setProjectState(dto.getProjectState());
        try {
            project.setClient(clientCRUDService.getEntityById(dto.getClientId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(ProjectBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return project;
    }

    @Override
    public ProjectDTO buildDTO(Project entity) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(entity.getId());
        projectDTO.setProjectName(entity.getProjectName());
        projectDTO.setDeadline(entity.getDeadline());
        projectDTO.setProjectState(entity.getProjectState());
        projectDTO.setClientId(entity.getClient().getId());
        return projectDTO;
    }

}
