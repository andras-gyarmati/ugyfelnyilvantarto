package xyz.codingmentor.consoleclient;

import xyz.codingmentor.consoleclient.api.IIOHandler;
import xyz.codingmentor.consoleclient.api.ISwitch;
import xyz.codingmentor.consoleclient.service.io.IOHandler;
import xyz.codingmentor.consoleclient.service.switchcase.index.IndexSwitch;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;

/**
 *
 * @author Tibor Kun
 */
public class Application {

    private final ISwitch indexSwitch;
    private static CurrentUser currentUser;
    public static final IIOHandler IO = IOHandler.getInstance();

    public Application() {
        this.indexSwitch = new IndexSwitch();
        currentUser = new CurrentUser(new UserDTO(), 0);
    }

    public void run() {
        indexSwitch.start();
    }

    public static CurrentUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(CurrentUser currentUser) {
        Application.currentUser = currentUser;
    }

}
