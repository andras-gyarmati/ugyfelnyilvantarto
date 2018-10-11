package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.USER)
public class UserCRUDService extends GenericEntityCRUDService<User> implements ICRUDService<User> {

    public UserCRUDService() {
        super(null);
    }

    @Inject
    public UserCRUDService(@CRUDRepositoryQualifier(EntityModel.USER) ICRUDRepository<User> repository) {
        super(repository);
    }

}
