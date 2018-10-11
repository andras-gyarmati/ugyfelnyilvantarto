package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.PROJECT)
public class ProjectCRUDService extends GenericEntityCRUDService<Project> implements ICRUDService<Project> {

    public ProjectCRUDService() {
        super(null);
    }

    @Inject
    public ProjectCRUDService(@CRUDRepositoryQualifier(EntityModel.PROJECT) ICRUDRepository<Project> repository) {
        super(repository);
    }

}
