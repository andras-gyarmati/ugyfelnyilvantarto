package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client;

import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;

/**
 *
 * @author brianelete
 */
public class ListClientsCase extends AbstractCase {

    private Pager<ClientDTO> pager;

    public ListClientsCase() {
        super("List Clients", URLProperty.getURL("Clients.url"));
    }

    @Override
    public void executeCase() {
        pager = new Pager(ClientDTO.class, caseMsg());
        pager.printList(getUrl());
    }

}
