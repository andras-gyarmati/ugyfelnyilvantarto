package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CONTACTCHANNEL)
public class ContactChannelCRUDService extends GenericEntityCRUDService<ContactChannel> implements ICRUDService<ContactChannel> {

    public ContactChannelCRUDService() {
        super(null);
    }

    @Inject
    public ContactChannelCRUDService(@CRUDRepositoryQualifier(EntityModel.CONTACTCHANNEL) ICRUDRepository<ContactChannel> repository) {
        super(repository);
    }

}
