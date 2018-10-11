package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.PROJECT)
public class ProjectCRUDRepository extends AbstractCRUDRepository<Project> implements ICRUDRepository<Project> {

    public ProjectCRUDRepository() {
        super("Project.getAll", "Project.count");
    }

    @Override
    protected Class<Project> getEntityClass() {
        return Project.class;
    }

}
