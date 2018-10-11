package xyz.codingmentor.team3.registry.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.dto.result.ResultDTO;
import xyz.codingmentor.team3.registry.dto.user.UserLoginDTO;
import xyz.codingmentor.team3.registry.exception.AuthenticationFailureException;

/**
 *
 * @author brianelete
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IAuthenticationRESTService {

    @POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, UserLoginDTO user) throws AuthenticationFailureException;

    @POST
    @Path("/logout")
    public ResultDTO logout(@Context HttpServletRequest request);
}
