package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import java.util.Arrays;
import java.util.Objects;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getPositionType;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.entity.person.PositionType;

/**
 *
 * @author brianelete
 */
public class EditDataCase extends AbstractCase {

    private final IHTTPRequest<UserDTO> httpRequest;
    private UserDTO userDTO;

    public EditDataCase() {
        super("Edit Data", URLProperty.getURL("Users.url"));
        this.httpRequest = new HTTPRequest<>(UserDTO.class);
    }

    @Override
    public void getInput() {
        if (Application.getCurrentUser().isAsmin()) {
            Application.IO.out("The user's id you want to modify: ");
            userDTO = httpRequest.get(getUrl() + Application.IO.getInteger());
            getAdminInput();
        } else {
            userDTO = httpRequest.get(getUrl() + Application.getCurrentUser().getUserDTO().getId());
            getUserInput();
        }
    }

    private void getUserInput() {
        Application.IO.outln(userDTO.toString());
        Application.IO.out("Firstname: ");
        userDTO.setFirstName(Application.IO.getString());
        Application.IO.out("Lastname: ");
        userDTO.setLastName(Application.IO.getString());
        Application.IO.out("Position" + Arrays.asList(PositionType.values()) + ": ");
        userDTO.setPosition(getPositionType());
        Application.IO.out("Profilpicture path: ");
        userDTO.setProfilePicturePath(Application.IO.getString());
        Application.IO.out("Username: ");
        userDTO.setUsername(Application.IO.getString());
        Application.IO.out("Password: ");
        userDTO.setPassword(Application.IO.getPassword());
    }

    private void getAdminInput() {
        getUserInput();
        Application.IO.out("Position" + Arrays.asList(PositionType.values()) + ": ");
        userDTO.setPosition(getPositionType());
    }

    @Override
    public void executeCase() {
        UserDTO responseUserDTO;
        responseUserDTO = httpRequest.put(this.getUrl(), userDTO);
        if (null != responseUserDTO) {
            if (Objects.equals(responseUserDTO.getId(), Application.getCurrentUser().getUserDTO().getId())) {
                Application.getCurrentUser().setUserDTO(responseUserDTO);
                Application.IO.outln("You have successfully updated your data!");
            }
        } else {
            Application.IO.outln("Invalid data! Please try again.");
        }
        Application.IO.getString();
    }

}
