package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.EVENT)
public class EventCRUDService extends GenericEntityCRUDService<Event> implements ICRUDService<Event> {

    public EventCRUDService() {
        super(null);
    }

    @Inject
    public EventCRUDService(@CRUDRepositoryQualifier(EntityModel.EVENT) ICRUDRepository<Event> repository) {
        super(repository);
    }

}
