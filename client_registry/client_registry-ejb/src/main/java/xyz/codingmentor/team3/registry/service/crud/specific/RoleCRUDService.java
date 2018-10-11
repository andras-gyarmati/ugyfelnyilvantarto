package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.ROLE)
public class RoleCRUDService extends GenericEntityCRUDService<Role> implements ICRUDService<Role> {

    public RoleCRUDService() {
        super(null);
    }

    @Inject
    public RoleCRUDService(@CRUDRepositoryQualifier(EntityModel.ROLE) ICRUDRepository<Role> repository) {
        super(repository);
    }

}
