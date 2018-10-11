package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.ADDRESS)
public class AddressCRUDRepository extends AbstractCRUDRepository<Address> implements ICRUDRepository<Address> {

    public AddressCRUDRepository() {
        super("Address.getAll", "Address.count");
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }

}
