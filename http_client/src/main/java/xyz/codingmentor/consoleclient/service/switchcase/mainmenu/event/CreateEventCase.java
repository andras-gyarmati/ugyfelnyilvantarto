package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event;

import java.util.Arrays;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.entitycreator.EntityCreator;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getEventType;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;
import xyz.codingmentor.team3.registry.entity.event.EventType;

/**
 *
 * @author brianelete
 */
public class CreateEventCase extends AbstractCase {

    private final IHTTPRequest<EventDTO> httpRequest;
    private EventDTO eventDTO;

    public CreateEventCase() {
        super("Create Event", URLProperty.getURL("Events.url"));
        this.httpRequest = new HTTPRequest<>(EventDTO.class);
        this.eventDTO = new EventDTO();
    }

    @Override
    public void getInput() {
        eventDTO = new EventDTO();
        Application.IO.out("Event type " + Arrays.asList(EventType.values()) + ": ");
        eventDTO.setType(getEventType());
        Application.IO.out("Event name: ");
        eventDTO.setEventName(Application.IO.getString());
        Application.IO.out("Start date: ");
        eventDTO.setStartDate(Application.IO.getDate());
        Application.IO.out("Finish date: ");
        eventDTO.setFinishDate(Application.IO.getDate());
        Application.IO.out("Client id: ");
        eventDTO.setClientId(Application.IO.getLong());
        eventDTO.setAddressId(EntityCreator.getAddress());
    }

    @Override
    public void executeCase() {
        eventDTO = httpRequest.post(getUrl(), eventDTO);
        if (null != eventDTO) {
            EntityCreator.getInvitation(eventDTO.getId());
            Application.IO.outln("Event " + eventDTO.getEventName() + " successfully saved!");
            EventDTO responseEventDTO = httpRequest.get(getUrl() + eventDTO.getId());
            if (null != responseEventDTO) {
                Application.IO.outln(responseEventDTO.toString());
            }
        } else {
            Application.IO.outln("Invalid data! Please try again.");
        }
        Application.IO.getString("Press any key to continue..");
    }

}
