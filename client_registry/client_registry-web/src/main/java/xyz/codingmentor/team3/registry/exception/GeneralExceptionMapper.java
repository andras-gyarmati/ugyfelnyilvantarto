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
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

    @Inject
    private Logger LOGGER;

    @Override
    public Response toResponse(Exception throwable) {
        LOGGER.log(Level.SEVERE, "General Exception", throwable);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResultDTO(ResultType.ERROR, throwable.getMessage() + " - " + throwable.getCause()))
                .type(MediaType.APPLICATION_JSON).build();
    }

}
