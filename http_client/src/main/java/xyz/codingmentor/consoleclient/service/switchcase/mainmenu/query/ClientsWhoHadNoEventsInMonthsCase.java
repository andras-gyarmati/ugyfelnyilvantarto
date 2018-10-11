package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;

/**
 *
 * @author brianelete
 */
public class ClientsWhoHadNoEventsInMonthsCase extends AbstractCase {

    private IPager pager;
    private int months;
    private static String title = "Clients with no events from the past ";

    public ClientsWhoHadNoEventsInMonthsCase() {
        super(title + "N months", URLProperty.getURL("Eventsinmonth.url"));
    }

    @Override
    public String getSeparator() {
        return "\n";
    }

    @Override
    public void getInput() {
        Application.IO.out("Months: ");
        months = Application.IO.getInteger();
    }

    private void updateTitleMonthCount(String n) {
        setCaseName(title + n + " months");
    }

    @Override
    public void executeCase() {
        updateTitleMonthCount(Integer.toString(months));
        pager = new Pager(ClientDTO.class, caseMsg());
        pager.printList(getUrl() + months + "/");
        updateTitleMonthCount("N");
    }

}
