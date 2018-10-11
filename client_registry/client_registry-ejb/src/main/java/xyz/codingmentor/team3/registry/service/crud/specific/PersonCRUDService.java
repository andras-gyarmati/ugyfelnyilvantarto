package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.PERSON)
public class PersonCRUDService extends GenericEntityCRUDService<Person> implements ICRUDService<Person> {

    public PersonCRUDService() {
        super(null);
    }

    @Inject
    public PersonCRUDService(@CRUDRepositoryQualifier(EntityModel.PERSON) ICRUDRepository<Person> repository) {
        super(repository);
    }

}
