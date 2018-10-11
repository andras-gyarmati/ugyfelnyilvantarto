package xyz.codingmentor.jms.cr.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daróczi Kristóf
 */
public interface IMessageService {
    
    @GET
    @Path("/getmessage")
    public Response getMessage();
}