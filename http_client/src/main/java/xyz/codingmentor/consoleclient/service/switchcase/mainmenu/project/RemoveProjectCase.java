package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;

/**
 *
 * @author brianelete
 */
public class RemoveProjectCase extends AbstractCase {

    private final IHTTPRequest<String> httpRequest;
    private Long projectId;

    public RemoveProjectCase() {
        super("Remove Project", URLProperty.getURL("Projects.url"));
        this.httpRequest = new HTTPRequest<>(String.class);
    }

    @Override
    public void getInput() {
        Application.IO.out("Please enter the ID of the project you want to delete: ");
        projectId = Application.IO.getLong();
    }

    @Override
    public void executeCase() {
        Application.IO.outln(httpRequest.delete(getUrl() + projectId));
        Application.IO.getString("Press any key to continue..");
    }

}
