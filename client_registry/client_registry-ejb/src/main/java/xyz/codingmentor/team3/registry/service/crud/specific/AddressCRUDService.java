package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.ADDRESS)
public class AddressCRUDService extends GenericEntityCRUDService<Address> implements ICRUDService<Address> {

    public AddressCRUDService() {
        super(null);
    }

    @Inject
    public AddressCRUDService(@CRUDRepositoryQualifier(EntityModel.ADDRESS) ICRUDRepository<Address> repository) {
        super(repository);
    }

}
