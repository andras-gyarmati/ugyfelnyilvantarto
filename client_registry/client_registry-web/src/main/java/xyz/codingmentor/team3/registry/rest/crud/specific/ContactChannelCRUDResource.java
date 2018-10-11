package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.contactchannel.ContactChannelDTO;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/contactchannels")
public class ContactChannelCRUDResource extends GenericCRUDResource<ContactChannelDTO, ContactChannel> {

    public ContactChannelCRUDResource() {
        super(null, null);
    }

    @Inject
    public ContactChannelCRUDResource(@CRUDServiceQualifier(EntityModel.CONTACTCHANNEL) ICRUDService<ContactChannel> crudService,
            @BuilderQualifier(EntityModel.CONTACTCHANNEL) IBuilder<ContactChannelDTO, ContactChannel> builder) {
        super(crudService, builder);
    }

}
