package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.INVITATION)
public class InvitationCRUDService extends GenericEntityCRUDService<Invitation> implements ICRUDService<Invitation> {

    public InvitationCRUDService() {
        super(null);
    }

    @Inject
    public InvitationCRUDService(@CRUDRepositoryQualifier(EntityModel.INVITATION) ICRUDRepository<Invitation> repository) {
        super(repository);
    }

}
