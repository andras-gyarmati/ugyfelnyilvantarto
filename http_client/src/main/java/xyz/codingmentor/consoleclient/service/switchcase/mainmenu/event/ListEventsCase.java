package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event;

import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;

/**
 *
 * @author brianelete
 */
public class ListEventsCase extends AbstractCase {

    private IPager pager;

    public ListEventsCase() {
        super("List Events", URLProperty.getURL("Events.url"));
    }

    @Override
    public void executeCase() {
        pager = new Pager(EventDTO.class, caseMsg());
        pager.printList(getUrl());
    }

}
