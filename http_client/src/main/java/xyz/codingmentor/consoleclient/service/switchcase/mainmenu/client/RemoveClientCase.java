package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;

/**
 *
 * @author brianelete
 */
public class RemoveClientCase extends AbstractCase {

    private final IHTTPRequest<String> httpRequest;
    private Long clientId;

    public RemoveClientCase() {
        super("Remove Client", URLProperty.getURL("Clients.url"));
        this.httpRequest = new HTTPRequest<>(String.class);
    }

    @Override
    public void getInput() {
        Application.IO.out("Please enter the ID of the clinet you want to delete: ");
        clientId = Application.IO.getLong();
    }

    @Override
    public void executeCase() {
        Application.IO.outln(httpRequest.delete(getUrl() + clientId));
        Application.IO.getString("Press any key to continue..");
    }

}
