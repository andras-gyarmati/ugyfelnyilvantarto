package xyz.codingmentor.team3.registry.service.builder;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.note.NoteDTO;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.NOTE)
public class NoteBuilder implements IBuilder<NoteDTO, Note> {

    @Inject
    @CRUDServiceQualifier(EntityModel.PERSON)
    ICRUDService<Person> personCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.EVENT)
    ICRUDService<Event> eventCRUDService;

    @Override
    public Note buildEntity(NoteDTO dto) {
        Note note = new Note();
        note.setId(dto.getId());
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        try {
            note.setPerson(personCRUDService.getEntityById(dto.getPersonId()));
            note.setEvent(eventCRUDService.getEntityById(dto.getEventId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(NoteBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return note;
    }

    @Override
    public NoteDTO buildDTO(Note entity) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(entity.getId());
        noteDTO.setTitle(entity.getTitle());
        noteDTO.setContent(entity.getContent());
        noteDTO.setPersonId(entity.getPerson().getId());
        noteDTO.setEventId(entity.getEvent().getId());
        return noteDTO;
    }

}
