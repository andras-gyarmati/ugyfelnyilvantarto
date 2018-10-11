package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.event.EventDTO;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.CreationMessage;
import xyz.codingmentor.team3.registry.qualifier.DeletionMessage;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;

/**
 *
 * @author brianelete
 */
@Path("/events")
public class EventCRUDResource extends GenericCRUDResource<EventDTO, Event> {

    @Inject
    @CreationMessage
    private javax.enterprise.event.Event<EventDTO> creationMessage;

    @Inject
    @DeletionMessage
    private javax.enterprise.event.Event<EventDTO> deletionMessage;

    public EventCRUDResource() {
        super(null, null);
    }

    @Inject
    public EventCRUDResource(@CRUDServiceQualifier(EntityModel.EVENT) ICRUDService<Event> crudService,
            @BuilderQualifier(EntityModel.EVENT) IBuilder<EventDTO, Event> build) {
        super(crudService, build);
    }

    @Override
    public Response create(EventDTO dto) throws RepositoryException {
        EventDTO eventDTO = getBuilder().buildDTO(getCrudService().createEntity(getBuilder().buildEntity(dto)));
        creationMessage.fire(eventDTO);
        return Response.ok(eventDTO).build();
    }

    @Override
    public Response delete(Long id) throws RepositoryException {
        deletionMessage.fire(getBuilder().buildDTO(getCrudService().getEntityById(id)));
        getCrudService().removeEntity(id);
        return Response.ok().build();
    }
}
