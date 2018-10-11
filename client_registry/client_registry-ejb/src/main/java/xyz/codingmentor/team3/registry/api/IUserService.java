package xyz.codingmentor.team3.registry.api;

import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author brianelete
 */
public interface IUserService {

    public User registrate(User user) throws RepositoryException;

    public User getUserByUserName(String username);

    public void addRole(Long userId, RoleType roleType) throws RepositoryException;

    public void removeRoleFromUser(Long userId, RoleType roleType) throws RepositoryException;
    
}
