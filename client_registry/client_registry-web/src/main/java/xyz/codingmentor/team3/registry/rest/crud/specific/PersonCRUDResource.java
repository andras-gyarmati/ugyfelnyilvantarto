package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.person.PersonDTO;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/people")
public class PersonCRUDResource extends GenericCRUDResource<PersonDTO, Person> {

    public PersonCRUDResource() {
        super(null, null);
    }

    @Inject
    public PersonCRUDResource(@CRUDServiceQualifier(EntityModel.PERSON) ICRUDService<Person> crudService,
            @BuilderQualifier(EntityModel.PERSON) IBuilder<PersonDTO, Person> builder) {
        super(crudService, builder);
    }

}
