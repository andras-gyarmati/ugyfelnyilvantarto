package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.CurrentUser;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;

/**
 *
 * @author brianelete
 */
public class LogoutCase extends AbstractCase {

    private final IHTTPRequest<String> httpRequest;
    private final MainMenuSwitch mainMenuSwitch;

    public LogoutCase(MainMenuSwitch mainMenuSwitch) {
        super("Logout", URLProperty.getURL("Logout.url"));
        this.httpRequest = new HTTPRequest<>(String.class);
        this.mainMenuSwitch = mainMenuSwitch;
    }

    @Override
    public void executeCase() {
        Application.IO.outln(httpRequest.post(this.getUrl()));
        Application.setCurrentUser(new CurrentUser(new UserDTO(), 0));
        mainMenuSwitch.stop();
    }

}
