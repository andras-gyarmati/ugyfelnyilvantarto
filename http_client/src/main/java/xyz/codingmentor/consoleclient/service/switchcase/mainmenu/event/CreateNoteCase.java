package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.event;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.note.NoteDTO;

/**
 *
 * @author brianelete
 */
public class CreateNoteCase extends AbstractCase {

    private final IHTTPRequest<NoteDTO> httpRequest;
    private final NoteDTO noteDTO;

    public CreateNoteCase() {
        super("Create Note", URLProperty.getURL("Notes.url"));
        this.httpRequest = new HTTPRequest<>(NoteDTO.class);
        this.noteDTO = new NoteDTO();
    }

    @Override
    public void getInput() {
        Application.IO.out("Title: ");
        noteDTO.setTitle(Application.IO.getString());
        Application.IO.out("Content: ");
        noteDTO.setContent(Application.IO.getString());
        noteDTO.setPersonId(Application.getCurrentUser().getUserDTO().getId());
        Application.IO.out("Event id: ");
        noteDTO.setEventId(Application.IO.getLong());
    }

    @Override
    public void executeCase() {
        Application.IO.outln(httpRequest.post(getUrl(), noteDTO).toString());
    }

}
