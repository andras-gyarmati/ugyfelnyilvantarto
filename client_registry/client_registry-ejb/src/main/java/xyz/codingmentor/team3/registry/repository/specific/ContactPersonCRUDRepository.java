package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.CONTACTPERSON)
public class ContactPersonCRUDRepository extends AbstractCRUDRepository<ContactPerson> implements ICRUDRepository<ContactPerson> {

    public ContactPersonCRUDRepository() {
        super("ContactPerson.getAll", "ContactPerson.count");
    }

    @Override
    protected Class<ContactPerson> getEntityClass() {
        return ContactPerson.class;
    }

}
