package xyz.codingmentor.team3.registry.interceptor.admin;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.RemoveAdminException;

/**
 *
 * @author Tibor Kun
 */
@Interceptor
public class AdminInterceptor {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    @AroundInvoke
    public Object adminChecker(InvocationContext ic) throws Exception {
        String selectQuery = "SELECT u FROM User u INNER JOIN u.roles r WHERE u.id = :userId AND r.roleType = :role";
        TypedQuery<User> query = entityManager.createQuery(selectQuery, User.class);
        query.setParameter("userId", (Long) ic.getParameters()[0]);
        query.setParameter("role", RoleType.ADMIN);
        if (!query.getResultList().isEmpty()) {
            methodSelector(ic);
        }
        return ic.proceed();
    }

    public void methodSelector(InvocationContext ic) {
        if (ic.getMethod().isAnnotationPresent(RemoveUser.class)) {
            adminCounter();
        } else if (ic.getMethod().isAnnotationPresent(RemoveRole.class)) {
            roleTypeChecker(ic);
        }
    }

    public void adminCounter() {
        String selectQuery = "SELECT COUNT(u) FROM User u INNER JOIN u.roles r WHERE r.roleType = :role";
        TypedQuery<Long> query = entityManager.createQuery(selectQuery, Long.class);
        query.setParameter("role", RoleType.ADMIN);
        if (query.getSingleResult() <= 1) {
            throw new RemoveAdminException("Must be at least one admin");
        }
    }

    public void roleTypeChecker(InvocationContext ic) {
        if (RoleType.ADMIN == (RoleType) ic.getParameters()[1]) {
            adminCounter();
        }
    }

}
