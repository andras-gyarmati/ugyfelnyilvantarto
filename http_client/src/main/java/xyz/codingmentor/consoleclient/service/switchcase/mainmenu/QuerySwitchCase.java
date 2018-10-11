package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitchCase;
import xyz.codingmentor.consoleclient.service.switchcase.BackCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query.ClientsWhoHadNoEventsInMonthsCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query.ClientsWhoHasMoreProjectsThanCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query.ContactChannelsofProjectCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query.NotesFromClientsEventCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query.ProjectsFinishesThisWeekCase;

/**
 *
 * @author brianelete
 */
public class QuerySwitchCase extends AbstractSwitchCase {

    public QuerySwitchCase() {
        super("Query");
    }

    @Override
    public void fillCases() {
        addCase(new BackCase("Back", this));
        addCase(new ContactChannelsofProjectCase());
        addCase(new NotesFromClientsEventCase());
        addCase(new ClientsWhoHadNoEventsInMonthsCase());
        addCase(new ProjectsFinishesThisWeekCase());
        addCase(new ClientsWhoHasMoreProjectsThanCase());
    }

}
