package xyz.codingmentor.jms.cr.web.message;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;

/**
 *
 * @author Daróczi Kristóf
 */
@MessageDriven(name = "deletion", activationConfig = {
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/deletion")})
public class DeletionMessageConsumer implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(DeletionMessageConsumer.class.getName());

    public DeletionMessageConsumer() {
        //empty on purpose
    }

    @Override
    public void onMessage(Message message) {
        try {
            LOGGER.info("Deleted event: " + message.getBody(EventDTO.class).toString());
        } catch (JMSException ex) {
            Logger.getLogger(DeletionMessageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
