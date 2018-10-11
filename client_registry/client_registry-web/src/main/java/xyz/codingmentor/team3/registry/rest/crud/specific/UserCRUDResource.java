package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author Tibor Kun
 */
@Path("/users")
public class UserCRUDResource extends GenericCRUDResource<UserDTO, User> {

    public UserCRUDResource() {
        super(null, null);
    }

    @Inject
    public UserCRUDResource(@CRUDServiceQualifier(EntityModel.USER) ICRUDService<User> crudService,
            @BuilderQualifier(EntityModel.USER) IBuilder<UserDTO, User> builder) {
        super(crudService, builder);
    }

}
