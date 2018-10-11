package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.PERSON)
public class PersonCRUDRepository extends AbstractCRUDRepository<Person> implements ICRUDRepository<Person> {

    public PersonCRUDRepository() {
        super("Person.getAll", "Person.count");
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

}
