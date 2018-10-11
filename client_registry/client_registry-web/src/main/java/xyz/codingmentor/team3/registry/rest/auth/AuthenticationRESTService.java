package xyz.codingmentor.team3.registry.rest.auth;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import xyz.codingmentor.team3.registry.api.IAuthenticationRESTService;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.IUserService;
import xyz.codingmentor.team3.registry.dto.result.ResultDTO;
import xyz.codingmentor.team3.registry.dto.result.ResultType;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.dto.user.UserLoginDTO;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.AuthenticationFailureException;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IViewCountService;
import xyz.codingmentor.team3.registry.qualifier.Login;

/**
 *
 * @author brianelete
 */
@Path("auth")
public class AuthenticationRESTService implements IAuthenticationRESTService {

    @Inject
    private Logger LOGGER;

    @Inject
    IUserService userService;

    @Inject
    IViewCountService viewCount;

    @Inject
    @BuilderQualifier(EntityModel.USER)
    private IBuilder<UserDTO, User> builder;

    @Inject
    @Login
    private Event<User> login;

    @Override
    @Interceptors(ValidatorInterceptor.class)
    public Response login(HttpServletRequest request, UserLoginDTO userLoginDTO) throws AuthenticationFailureException {
        try {
            if (null != request.getUserPrincipal()) {
                throw new AuthenticationFailureException("You are already logged in! Username: " + request.getUserPrincipal());
            }
            request.login(userLoginDTO.getUsername(), sha256Hex(userLoginDTO.getPassword()));
            LOGGER.log(Level.INFO, "Login Success for: {0}", request.getUserPrincipal());
            User loggedInUser = userService.getUserByUserName(userLoginDTO.getUsername());
            login.fire(loggedInUser);
            return Response.ok(builder.buildDTO(loggedInUser)).build();
        } catch (ServletException e) {
            LOGGER.log(Level.SEVERE, "Login Exception: {0}", e);
        }
        throw new AuthenticationFailureException(userLoginDTO.getUsername());
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public ResultDTO logout(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        if (null != username) {
            try {
                request.logout();
                request.getSession().invalidate();
                return new ResultDTO(ResultType.SUCCESS, username + " have successfully logged out!");
            } catch (ServletException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
        return new ResultDTO(ResultType.ERROR, "Already logged out!");
    }

}
