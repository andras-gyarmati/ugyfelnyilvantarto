package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.contactperson.ContactPersonDTO;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/contactpeople")
public class ContactPersonCRUDResource extends GenericCRUDResource<ContactPersonDTO, ContactPerson> {

    public ContactPersonCRUDResource() {
        super(null, null);
    }

    @Inject
    public ContactPersonCRUDResource(@CRUDServiceQualifier(EntityModel.CONTACTPERSON) ICRUDService<ContactPerson> crudService,
            @BuilderQualifier(EntityModel.CONTACTPERSON) IBuilder<ContactPersonDTO, ContactPerson> builder) {
        super(crudService, builder);
    }

}
