package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.ROLE)
public class RoleCRUDRepository extends AbstractCRUDRepository<Role> implements ICRUDRepository<Role> {

    public RoleCRUDRepository() {
        super("Role.getAll", "Role.count");
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

}
