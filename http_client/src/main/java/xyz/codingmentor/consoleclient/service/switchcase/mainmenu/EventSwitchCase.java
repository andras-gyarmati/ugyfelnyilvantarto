package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitchCase;
import xyz.codingmentor.consoleclient.service.switchcase.BackCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event.CreateEventCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event.CreateNoteCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event.EditInvitationCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event.ListEventsCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event.RemoveEventCase;

/**
 *
 * @author brianelete
 */
public class EventSwitchCase extends AbstractSwitchCase {

    public EventSwitchCase() {
        super("Event");
    }

    @Override
    public void fillCases() {
        addCase(new BackCase("Back", this));
        addCase(new ListEventsCase());
        addCase(new CreateEventCase());
        addCase(new CreateNoteCase());
        addCase(new EditInvitationCase());
        addCase(new RemoveEventCase());
    }

}
