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
public class ClientsWhoHasMoreProjectsThanCase extends AbstractCase {

    private IPager pager;
    private int projectCount;
    private static String title = "Clients who are Ltd-s and has more projects than ";

    public ClientsWhoHasMoreProjectsThanCase() {
        super(title + "N", URLProperty.getURL("Moreprojectsthan.url"));
    }

    @Override
    public String getSeparator() {
        return "\n";
    }

    @Override
    public void getInput() {
        Application.IO.out("Project count: ");
        projectCount = Application.IO.getInteger();
    }

    private void changeTitleProjectCount(String n) {
        setCaseName(title + n);
    }

    @Override
    public void executeCase() {
        changeTitleProjectCount(Integer.toString(projectCount));
        pager = new Pager(ClientDTO.class, caseMsg());
        pager.printList(getUrl() + projectCount + "/");
        changeTitleProjectCount("N");
    }

}
