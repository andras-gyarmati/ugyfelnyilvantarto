package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.address.AddressDTO;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/addresses")
public class AddressCRUDResource extends GenericCRUDResource<AddressDTO, Address> {

    public AddressCRUDResource() {
        super(null, null);
    }

    @Inject
    public AddressCRUDResource(@CRUDServiceQualifier(EntityModel.ADDRESS) ICRUDService<Address> crudService,
            @BuilderQualifier(EntityModel.ADDRESS) IBuilder<AddressDTO, Address> build) {
        super(crudService, build);
    }

}
