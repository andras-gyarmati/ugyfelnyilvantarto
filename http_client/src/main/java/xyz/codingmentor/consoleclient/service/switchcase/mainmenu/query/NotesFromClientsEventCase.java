package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.note.NoteDTO;

/**
 *
 * @author brianelete
 */
public class NotesFromClientsEventCase extends AbstractCase {

    private IPager pager;
    private Long clientId;

    public NotesFromClientsEventCase() {
        super("Client's event's public notes from contributors", URLProperty.getURL("Notesfromclient.url"));
    }

    @Override
    public String getSeparator() {
        return "\n";
    }

    @Override
    public void getInput() {
        Application.IO.out("Client id: ");
        clientId = Application.IO.getLong();
    }

    @Override
    public void executeCase() {
        pager = new Pager(NoteDTO.class, caseMsg());
        pager.printList(getUrl() + clientId + "/");
    }

}
