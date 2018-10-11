package xyz.codingmentor.team3.registry.repository.specific;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.admin.AdminInterceptor;
import xyz.codingmentor.team3.registry.interceptor.admin.RemoveUser;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.USER)
public class UserCRUDRepository extends AbstractCRUDRepository<User> implements ICRUDRepository<User> {

    public UserCRUDRepository() {
        super("User.getAll", "User.count");
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    @Interceptors(ValidatorInterceptor.class)
    @PermitAll
    public User persist(User entity) throws RepositoryException {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

    @Override
    @RemoveUser
    @Interceptors(AdminInterceptor.class)
    public void remove(Long entityId) throws RepositoryException {
        super.remove(entityId);
    }

}
