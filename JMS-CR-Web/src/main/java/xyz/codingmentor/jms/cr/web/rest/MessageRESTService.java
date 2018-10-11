package xyz.codingmentor.jms.cr.web.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jms.cr.web.api.IMessageService;
import xyz.codingmentor.jms.cr.web.message.EventMessage;

/**
 *
 * @author DarĂłczi KristĂłf
 */
@Stateless
@Path("/jms")
public class MessageRESTService implements IMessageService {

   
    @Override
    public Response getMessage() {
        EventMessage messageBean=new EventMessage();
       return Response.ok(messageBean.consumeFromTopic()).build();
    }
    
}
