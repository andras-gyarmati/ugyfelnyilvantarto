package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitch;

/**
 *
 * @author brianelete
 */
public class MainMenuSwitch extends AbstractSwitch {

    public MainMenuSwitch() {
        super("Main menu");
    }

    @Override
    public void fillCases() {
        addCase(new LogoutCase(this));
        addCase(new EditDataCase());
        addCase(new ClientSwitchCase());
        addCase(new ProjectSwitchCase());
        addCase(new EventSwitchCase());
        addCase(new QuerySwitchCase());
    }

}
