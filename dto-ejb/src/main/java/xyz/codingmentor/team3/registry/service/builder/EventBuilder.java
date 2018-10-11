package xyz.codingmentor.team3.registry.service.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.EVENT)
public class EventBuilder implements IBuilder<EventDTO, Event> {

    @Inject
    @CRUDServiceQualifier(EntityModel.CLIENT)
    ICRUDService<Client> clientCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.ADDRESS)
    ICRUDService<Address> addressCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.NOTE)
    ICRUDService<Note> noteCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.INVITATION)
    ICRUDService<Invitation> invitationCRUDService;

    @Override
    public Event buildEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setType(dto.getType());
        event.setStartDate(dto.getStartDate());
        event.setFinishDate(dto.getFinishDate());
        event.setEventName(dto.getEventName());
        try {
            event.setClient(clientCRUDService.getEntityById(dto.getClientId()));
            event.setAddress(addressCRUDService.getEntityById(dto.getAddressId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        event.setNotes(readNotes(dto));
        event.setInvitations(readInvitations(dto));
        return event;
    }

    @Override
    public EventDTO buildDTO(Event entity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(entity.getId());
        eventDTO.setType(entity.getType());
        eventDTO.setStartDate(entity.getStartDate());
        eventDTO.setFinishDate(entity.getFinishDate());
        eventDTO.setEventName(entity.getEventName());
        eventDTO.setClientId(entity.getClient().getId());
        eventDTO.setAddressId(entity.getAddress().getId());
        eventDTO.setNoteIdList(readNotes(entity));
        eventDTO.setInvitationIdList(readInvitations(entity));
        return eventDTO;
    }

    private List<Note> readNotes(EventDTO dto) {
        List<Note> notes = new ArrayList();
        if (null != dto.getNoteIdList()) {
            dto.getNoteIdList().forEach((noteId) -> {
                try {
                    notes.add(noteCRUDService.getEntityById(noteId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return notes;
    }

    private List<Invitation> readInvitations(EventDTO dto) {
        List<Invitation> invitations = new ArrayList();
        if (null != dto.getInvitationIdList()) {
            dto.getInvitationIdList().forEach((invitationId) -> {
                try {
                    invitations.add(invitationCRUDService.getEntityById(invitationId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return invitations;
    }

    private List<Long> readNotes(Event entity) {
        List<Long> noteIdList = new ArrayList();
        if (null != entity.getNotes()) {
            entity.getNotes().forEach((note) -> {
                noteIdList.add(note.getId());
            });
        }
        return noteIdList;
    }

    private List<Long> readInvitations(Event entity) {
        List<Long> invitationIdList = new ArrayList();
        if (null != entity.getInvitations()) {
            entity.getInvitations().forEach((invitation) -> {
                invitationIdList.add(invitation.getId());
            });
        }
        return invitationIdList;
    }

}
