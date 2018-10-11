package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/clients")
public class ClientCRUDResource extends GenericCRUDResource<ClientDTO, Client> {

    public ClientCRUDResource() {
        super(null, null);
    }

    @Inject
    public ClientCRUDResource(@CRUDServiceQualifier(EntityModel.CLIENT) ICRUDService<Client> crudService,
            @BuilderQualifier(EntityModel.CLIENT) IBuilder<ClientDTO, Client> builder) {
        super(crudService, builder);
    }

}
