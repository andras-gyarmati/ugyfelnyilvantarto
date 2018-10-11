package xyz.codingmentor.team3.registry.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.IEventMessageBean;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;
import xyz.codingmentor.team3.registry.qualifier.CreationMessage;
import xyz.codingmentor.team3.registry.qualifier.DeletionMessage;
import xyz.codingmentor.team3.registry.qualifier.JMSQualifier;

/**
 *
 * @author Daróczi Kristóf
 */
public class JMSmessageCreator {

    @Inject
    @JMSQualifier
    private IEventMessageBean messageBean;

    public void sendCreationMessage(@Observes @CreationMessage EventDTO eventDTO) {
        messageBean.createCreationMessage(eventDTO);
    }

    public void sendDeletionMessage(@Observes @DeletionMessage EventDTO eventDTO) {
        messageBean.createDeletionMessage(eventDTO);
    }
}
