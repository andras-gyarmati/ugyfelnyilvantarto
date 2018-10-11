package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.invitation.InvitationDTO;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/invitations")
public class InvitationCRUDResource extends GenericCRUDResource<InvitationDTO, Invitation> {

    public InvitationCRUDResource() {
        super(null, null);
    }

    @Inject
    public InvitationCRUDResource(@CRUDServiceQualifier(EntityModel.INVITATION) ICRUDService<Invitation> crudService,
            @BuilderQualifier(EntityModel.INVITATION) IBuilder<InvitationDTO, Invitation> builder) {
        super(crudService, builder);
    }

}
