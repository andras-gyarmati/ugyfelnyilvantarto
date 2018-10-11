package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.CONTACTCHANNEL)
public class ContactChannelCRUDRepository extends AbstractCRUDRepository<ContactChannel> implements ICRUDRepository<ContactChannel> {

    public ContactChannelCRUDRepository() {
        super("ContactChannel.getAll", "ContactChannel.count");
    }

    @Override
    protected Class<ContactChannel> getEntityClass() {
        return ContactChannel.class;
    }

}
