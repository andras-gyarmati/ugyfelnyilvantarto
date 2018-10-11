package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitchCase;
import xyz.codingmentor.consoleclient.service.switchcase.BackCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client.CreateClientCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client.ListClientsCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client.RemoveClientCase;

/**
 *
 * @author brianelete
 */
public class ClientSwitchCase extends AbstractSwitchCase {

    public ClientSwitchCase() {
        super("Client");
    }

    @Override
    public void fillCases() {
        addCase(new BackCase("Back", this));
        addCase(new ListClientsCase());
        addCase(new CreateClientCase());
        addCase(new RemoveClientCase());
    }

}
