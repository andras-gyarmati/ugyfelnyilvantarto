package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.contactchannel.ContactChannelDTO;

/**
 *
 * @author brianelete
 */
public class ContactChannelsofProjectCase extends AbstractCase {

    private IPager pager;
    private Long projectId;

    public ContactChannelsofProjectCase() {
        super("Project's contactperson's contactchannels", URLProperty.getURL("Projectcontacts.url"));
    }

    @Override
    public String getSeparator() {
        return "\n";
    }

    @Override
    public void getInput() {
        Application.IO.out("Project id: ");
        projectId = Application.IO.getLong();
    }

    @Override
    public void executeCase() {
        pager = new Pager(ContactChannelDTO.class, caseMsg());
        pager.printList(getUrl() + projectId + "/");
    }

}
