package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CONTACTPERSON)
public class ContactPersonCRUDService extends GenericEntityCRUDService<ContactPerson> implements ICRUDService<ContactPerson> {

    public ContactPersonCRUDService() {
        super(null);
    }

    @Inject
    public ContactPersonCRUDService(@CRUDRepositoryQualifier(EntityModel.CONTACTPERSON) ICRUDRepository<ContactPerson> repository) {
        super(repository);
    }

}
