package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.role.RoleDTO;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author Tibor Kun
 */
@Path("/roles")
public class RoleCRUDResource extends GenericCRUDResource<RoleDTO, Role> {

    public RoleCRUDResource() {
        super(null, null);
    }

    @Inject
    public RoleCRUDResource(@CRUDServiceQualifier(EntityModel.ROLE) ICRUDService<Role> crudService,
            @BuilderQualifier(EntityModel.ROLE) IBuilder<RoleDTO, Role> builder) {
        super(crudService, builder);
    }

}
