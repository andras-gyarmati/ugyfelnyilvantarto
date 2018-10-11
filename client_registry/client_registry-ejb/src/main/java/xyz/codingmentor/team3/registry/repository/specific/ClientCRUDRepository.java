package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.client.Client;
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
@CRUDRepositoryQualifier(EntityModel.CLIENT)
public class ClientCRUDRepository extends AbstractCRUDRepository<Client> implements ICRUDRepository<Client> {

    @Inject
    @RemoveAddress
    private Event<Long> removeClient;

    public ClientCRUDRepository() {
        super("Client.getAll", "Client.count");
    }

    @Override
    protected Class<Client> getEntityClass() {
        return Client.class;
    }

    @Override
    public void remove(Long entityId) throws RepositoryException {
        Long addressId = find(entityId).getAddress().getId();
        super.remove(entityId);
        removeClient.fire(addressId);
    }

}
