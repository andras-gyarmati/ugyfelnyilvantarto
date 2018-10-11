package xyz.codingmentor.consoleclient.service.switchcase.index;

import java.util.Arrays;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.CurrentUser;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getPositionType;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.MainMenuSwitch;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.entity.person.PositionType;

/**
 *
 * @author brianelete
 */
public class RegCase extends AbstractCase {

    private final IHTTPRequest<UserDTO> httpRequest;
    private UserDTO userDTO;
    private int pagesize;
    private MainMenuSwitch mainMenuSwitch;

    public RegCase() {
        super("Registrate", URLProperty.getURL("Registrate.url"));
        this.httpRequest = new HTTPRequest<>(UserDTO.class);
        this.userDTO = new UserDTO();
    }

    @Override
    public void getInput() {
        this.userDTO = new UserDTO();
        Application.IO.out("Firstname: ");
        userDTO.setFirstName(Application.IO.getString());
        Application.IO.out("Lastname: ");
        userDTO.setLastName(Application.IO.getString());
        Application.IO.out("Position" + Arrays.asList(PositionType.values()) + ": ");
        userDTO.setPosition(getPositionType());
        Application.IO.out("Username: ");
        userDTO.setUsername(Application.IO.getString());
        Application.IO.out("Password: ");
        userDTO.setPassword(Application.IO.getPassword());
        Application.IO.out("Pagesize(min 1): ");
        pagesize = Math.max(1, Application.IO.getInteger());
    }

    @Override
    public void executeCase() {
        userDTO = httpRequest.post(getUrl(), userDTO);
        if (null != userDTO) {
            Application.setCurrentUser(new CurrentUser(userDTO, pagesize));
            mainMenuSwitch = new MainMenuSwitch();
            mainMenuSwitch.start();
        } else {
            Application.IO.outln("Failed to registrate!");
        }
    }

}
