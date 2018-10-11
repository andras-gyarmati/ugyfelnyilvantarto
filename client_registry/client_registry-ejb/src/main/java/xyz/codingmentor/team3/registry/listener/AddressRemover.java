package xyz.codingmentor.team3.registry.listener;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.RemoveAddress;

/**
 *
 * @author Tibor Kun
 */
public class AddressRemover {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    private TypedQuery<Long> countQuery;
    private Long addressCount = 0L;

    public void addressCounter(@Observes @RemoveAddress Long addressId) throws RepositoryException {
        countQuery = entityManager.createNamedQuery("Event.countAddress", Long.class);
        runQuery(addressId);
        countQuery = entityManager.createNamedQuery("Client.countAddress", Long.class);
        runQuery(addressId);
        deleteAddress(addressId);
    }

    public void runQuery(Long addressId) {
        countQuery.setParameter("addressId", addressId);
        addressCount += countQuery.getSingleResult();
    }

    public void deleteAddress(Long addressId) throws RepositoryException {
        if (0 == addressCount) {
            entityManager.remove(entityManager.find(Address.class, addressId));
        }
    }

}
