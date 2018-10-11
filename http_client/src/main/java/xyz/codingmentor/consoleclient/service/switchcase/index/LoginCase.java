package xyz.codingmentor.consoleclient.service.switchcase.index;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.CurrentUser;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.MainMenuSwitch;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.dto.user.UserLoginDTO;

/**
 *
 * @author brianelete
 */
public class LoginCase extends AbstractCase {

    private final UserLoginDTO userLoginDTO;
    private UserDTO userDTO;
    private final IHTTPRequest<UserDTO> httpRequest;
    private int pagesize;
    private MainMenuSwitch mainMenuSwitch;

    public LoginCase() {
        super("Login", URLProperty.getURL("Login.url"));
        this.httpRequest = new HTTPRequest<>(UserDTO.class);
        this.userLoginDTO = new UserLoginDTO();
    }

    @Override
    public void getInput() {
        Application.IO.out("Username: ");
        userLoginDTO.setUsername(Application.IO.getString());
        Application.IO.out("Password: ");
        userLoginDTO.setPassword(Application.IO.getPassword());
        Application.IO.out("Pagesize(min 1): ");
        pagesize = Math.max(1, Application.IO.getInteger());
    }

    @Override
    public void executeCase() {
        userDTO = httpRequest.post(this.getUrl(), userLoginDTO);
        authenticate();
        Application.setCurrentUser(new CurrentUser(userDTO, pagesize));
        mainMenuSwitch = new MainMenuSwitch();
        mainMenuSwitch.start();
    }

    private void authenticate() {
        while (null == userDTO) {
            Application.IO.outln("Wrong username or password!");
            getInput();
            userDTO = httpRequest.post(this.getUrl(), userLoginDTO);
        }
    }

}
