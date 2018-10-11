package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CLIENT)
public class ClientCRUDService extends GenericEntityCRUDService<Client> implements ICRUDService<Client> {

    public ClientCRUDService() {
        super(null);
    }

    @Inject
    public ClientCRUDService(@CRUDRepositoryQualifier(EntityModel.CLIENT) ICRUDRepository<Client> repository) {
        super(repository);
    }

}
