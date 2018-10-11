package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;

/**
 *
 * @author brianelete
 */
public class RemoveEventCase extends AbstractCase {

    private final IHTTPRequest<String> httpRequest;
    private Long eventId;

    public RemoveEventCase() {
        super("Remove Event", URLProperty.getURL("Events.url"));
        this.httpRequest = new HTTPRequest<>(String.class);
    }

    @Override
    public void getInput() {
        Application.IO.out("Please enter the ID of the event you want to delete: ");
        eventId = Application.IO.getLong();
    }

    @Override
    public void executeCase() {
        Application.IO.outln(httpRequest.delete(getUrl() + eventId));
        Application.IO.getString("Press any key to continue..");
    }

}
