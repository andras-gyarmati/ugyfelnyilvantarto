package xyz.codingmentor.team3.registry.service.crud.specific;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.service.crud.GenericEntityCRUDService;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDServiceQualifier(EntityModel.NOTE)
public class NoteCRUDService extends GenericEntityCRUDService<Note> implements ICRUDService<Note> {

    public NoteCRUDService() {
        super(null);
    }

    @Inject
    public NoteCRUDService(@CRUDRepositoryQualifier(EntityModel.NOTE) ICRUDRepository<Note> repository) {
        super(repository);
    }

}
