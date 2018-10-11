package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.RemoveAddress;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.EVENT)
public class EventCRUDRepository extends AbstractCRUDRepository<Event> implements ICRUDRepository<Event> {

    @Inject
    @RemoveAddress
    private javax.enterprise.event.Event<Long> removeInvitation;

    public EventCRUDRepository() {
        super("Event.getAll", "Event.count");
    }

    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }

    @Override
    public void remove(Long entityId) throws RepositoryException {
        Long addressId = find(entityId).getAddress().getId();
        super.remove(entityId);
        removeInvitation.fire(addressId);
    }

}
