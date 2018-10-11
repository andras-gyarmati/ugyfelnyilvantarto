package xyz.codingmentor.team3.registry.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import xyz.codingmentor.team3.registry.api.IEventMessageBean;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;
import xyz.codingmentor.team3.registry.qualifier.JMSQualifier;

/**
 *
 * @author Daróczi Kristóf
 */
@Stateless
@JMSQualifier
public class EventMessageBean implements IEventMessageBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/deletion")
    private Topic deletionTopic;

    @Resource(lookup = "java:/jms/creation")
    private Topic creationTopic;

    @Override
    public void produceMessageToDeletionTopic(ObjectMessage eventMessage) {
        context.createProducer().send(deletionTopic, eventMessage);
    }

    @Override
    public void produceMessageToCreationTopic(ObjectMessage eventMessage) {
        context.createProducer().send(creationTopic, eventMessage);
    }

    @Override
    public void createDeletionMessage(EventDTO eventDTO) {
        ObjectMessage message = context.createObjectMessage(eventDTO);
        produceMessageToDeletionTopic(message);
    }

    @Override
    public void createCreationMessage(EventDTO eventDTO) {
        ObjectMessage message = context.createObjectMessage(eventDTO);
        produceMessageToCreationTopic(message);
    }

}
