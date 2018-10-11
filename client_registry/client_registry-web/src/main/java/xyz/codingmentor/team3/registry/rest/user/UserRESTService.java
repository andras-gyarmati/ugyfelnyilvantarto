package xyz.codingmentor.team3.registry.rest.user;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.IUserRESTService;
import xyz.codingmentor.team3.registry.api.IUserService;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.dto.user.UserLoginDTO;
import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.AuthenticationFailureException;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IAuthenticationRESTService;

/**
 *
 * @author brianelete
 */
@Path("/user")
public class UserRESTService implements IUserRESTService {

    @Inject
    IUserService userService;

    @Inject
    IAuthenticationRESTService authService;

    @Inject
    @BuilderQualifier(EntityModel.USER)
    private IBuilder<UserDTO, User> builder;

    @Override
    @Interceptors(ValidatorInterceptor.class)
    public Response registrate(HttpServletRequest request, UserDTO userDTO) throws RepositoryException, AuthenticationFailureException {
        if (null != request.getUserPrincipal()) {
            throw new AuthenticationFailureException("You are already logged in! Username: " + request.getUserPrincipal());
        }
        userService.registrate(builder.buildEntity(userDTO));
        return authService.login(request, new UserLoginDTO(userDTO.getUsername(), userDTO.getPassword()));
    }

    @Override
    public UserDTO getUserByUserName(String username) {
        return builder.buildDTO(userService.getUserByUserName(username));
    }

    @Override
    @Interceptors(ValidatorInterceptor.class)
    public void addRole(Long userId, RoleType roleType) throws RepositoryException {
        userService.addRole(userId, roleType);
    }

    @Override
    public void removeRoleFromUser(Long userId, RoleType roleType) throws RepositoryException {
        userService.removeRoleFromUser(userId, roleType);
    }

}
