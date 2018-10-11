package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.INVITATION)
public class InvitationCRUDRepository extends AbstractCRUDRepository<Invitation> implements ICRUDRepository<Invitation> {

    public InvitationCRUDRepository() {
        super("Invitation.getAll", "Invitation.count");
    }

    @Override
    protected Class<Invitation> getEntityClass() {
        return Invitation.class;
    }

}
