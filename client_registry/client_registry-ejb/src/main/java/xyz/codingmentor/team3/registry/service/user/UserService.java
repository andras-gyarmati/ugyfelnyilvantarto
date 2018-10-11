package xyz.codingmentor.team3.registry.service.user;

import java.util.Arrays;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.api.IUserService;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.admin.AdminInterceptor;
import xyz.codingmentor.team3.registry.interceptor.admin.RemoveRole;
import xyz.codingmentor.team3.registry.interceptor.log.LoggingInterceptor;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author brianelete
 */
@Stateless
@Interceptors({LoggingInterceptor.class, ValidatorInterceptor.class})
public class UserService implements IUserService {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    private ICRUDService<User> userCRUDService;

    public UserService() {
        //empty
    }

    @Inject
    UserService(@CRUDServiceQualifier(EntityModel.USER) ICRUDService<User> userCRUDService) {
        this.userCRUDService = userCRUDService;
    }

    @Override
    public User registrate(User user) throws RepositoryException {
        user.setRoles(Arrays.asList(getRoleByRoleType(RoleType.USER)));
        return userCRUDService.createEntity(user);
    }

    @Override
    public void addRole(Long userId, RoleType roleType) throws RepositoryException {
        User user = userCRUDService.getEntityById(userId);
        Role role = getRoleByRoleType(roleType);
        if (null == user.getRoles()) {
            user.setRoles(Arrays.asList(role));
        } else if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
            userCRUDService.updateEntity(user);
        }
    }

    @Override
    @RemoveRole
    @Interceptors(AdminInterceptor.class)
    public void removeRoleFromUser(Long userId, RoleType roleType) throws RepositoryException {
        User user = userCRUDService.getEntityById(userId);
        Role role = getRoleByRoleType(roleType);
        if (user.getRoles().size() <= 1) {
            throw new RepositoryException("Must be at least one role!");
        }
        if (user.getRoles().contains(role)) {
            user.getRoles().remove(role);
        }
    }

    @Override
    public User getUserByUserName(String username) {
        String selectQuery = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> query = entityManager.createQuery(selectQuery, User.class
        );
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    private Role getRoleByRoleType(RoleType roleType) {
        String selectQuery = "SELECT r FROM Role r WHERE r.roleType = :roleType";
        TypedQuery<Role> query = entityManager.createQuery(selectQuery, Role.class
        );
        query.setParameter("roleType", roleType);
        return query.getSingleResult();
    }

}
