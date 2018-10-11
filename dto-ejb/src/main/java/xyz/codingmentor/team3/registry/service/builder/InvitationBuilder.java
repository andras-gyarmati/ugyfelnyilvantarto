package xyz.codingmentor.team3.registry.service.builder;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.invitation.InvitationDTO;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.INVITATION)
public class InvitationBuilder implements IBuilder<InvitationDTO, Invitation> {

    @Inject
    @CRUDServiceQualifier(EntityModel.EVENT)
    ICRUDService<Event> eventCRUDService;

    @Override
    public Invitation buildEntity(InvitationDTO dto) {
        Invitation invitation = new Invitation();
        invitation.setId(dto.getId());
        invitation.setDescription(dto.getDescription());
        try {
            invitation.setEvent(eventCRUDService.getEntityById(dto.getEventId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(InvitationBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        invitation.setStatus(dto.getStatus());
        return invitation;
    }

    @Override
    public InvitationDTO buildDTO(Invitation entity) {
        InvitationDTO invitationDTO = new InvitationDTO();
        invitationDTO.setId(entity.getId());
        invitationDTO.setDescription(entity.getDescription());
        invitationDTO.setEventId(entity.getEvent().getId());
        invitationDTO.setStatus(entity.getStatus());
        return invitationDTO;
    }

}
