package xyz.codingmentor.team3.registry.api;

import javax.jms.ObjectMessage;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;

/**
 *
 * @author Daróczi Kristóf
 */
public interface IEventMessageBean {

    void produceMessageToDeletionTopic(ObjectMessage eventDTOMessage);

    void produceMessageToCreationTopic(ObjectMessage eventDTOMessage);

    void createDeletionMessage(EventDTO eventDTO);

    void createCreationMessage(EventDTO eventDTO);

}
