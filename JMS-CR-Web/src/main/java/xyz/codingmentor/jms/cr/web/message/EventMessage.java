package xyz.codingmentor.jms.cr.web.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import xyz.codingmentor.team3.registry.entity.event.Event;

/**
 *
 * @author Daróczi Kristóf
 */
@Stateless
public class EventMessage {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/deletion")
    private Topic deletionTopic;

    @Resource(lookup = "java:/jms/creation")
    private Topic creationTopic;

    public Event consumeFromTopic() {
        return context.createDurableConsumer(deletionTopic, "myName").receiveBody(Event.class);
    }

}
