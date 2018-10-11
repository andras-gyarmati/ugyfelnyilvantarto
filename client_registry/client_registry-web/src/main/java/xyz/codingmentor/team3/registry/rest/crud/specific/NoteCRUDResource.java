package xyz.codingmentor.team3.registry.rest.crud.specific;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.note.NoteDTO;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.rest.crud.GenericCRUDResource;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@Path("/notes")
public class NoteCRUDResource extends GenericCRUDResource<NoteDTO, Note> {

    public NoteCRUDResource() {
        super(null, null);
    }

    @Inject
    public NoteCRUDResource(@CRUDServiceQualifier(EntityModel.NOTE) ICRUDService<Note> crudService,
            @BuilderQualifier(EntityModel.NOTE) IBuilder<NoteDTO, Note> builder) {
        super(crudService, builder);
    }

}
