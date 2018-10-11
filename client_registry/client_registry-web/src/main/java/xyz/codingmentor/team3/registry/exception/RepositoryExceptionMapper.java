package xyz.codingmentor.team3.registry.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.team3.registry.dto.result.ResultDTO;
import xyz.codingmentor.team3.registry.dto.result.ResultType;

/**
 *
 * @author Daróczi Kristóf
 */
@Provider
public class RepositoryExceptionMapper implements ExceptionMapper<RepositoryException> {

    @Inject
    private Logger LOGGER;

    @Override
    public Response toResponse(RepositoryException throwable) {
        LOGGER.log(Level.SEVERE, "Repository Exception", throwable);
        return Response.status(Response.Status.EXPECTATION_FAILED)
                .entity(new ResultDTO(ResultType.ERROR, throwable.getMessage() + " - " + throwable.getCause()))
                .type(MediaType.APPLICATION_JSON).build();
    }

}
