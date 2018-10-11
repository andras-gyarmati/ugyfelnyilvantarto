package xyz.codingmentor.team3.registry.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.entity.role.RoleType;
import xyz.codingmentor.team3.registry.exception.AuthenticationFailureException;
import xyz.codingmentor.team3.registry.exception.RepositoryException;

/**
 *
 * @author brianelete
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IUserRESTService {

    @POST
    @Path("/registrate")
    public Response registrate(@Context HttpServletRequest request, UserDTO userDTO) throws RepositoryException, AuthenticationFailureException;

    @GET
    @Path("/get/{username}")
    public UserDTO getUserByUserName(@PathParam("username") String username);

    @POST
    @Path("/addrole/{userId}/{roleType}")
    public void addRole(@PathParam("userId") Long userId, @PathParam("roleType") RoleType roleType) throws RepositoryException;

    @POST
    @Path("/removerole/{userId}/{roleType}")
    public void removeRoleFromUser(@PathParam("userId") Long userId, @PathParam("roleType") RoleType roleType) throws RepositoryException;
}
