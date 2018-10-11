package xyz.codingmentor.team3.registry.repository.specific;

import javax.ejb.Stateless;
import xyz.codingmentor.team3.registry.api.ICRUDRepository;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.qualifier.CRUDRepositoryQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.repository.AbstractCRUDRepository;

/**
 *
 * @author Tibor Kun
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.NOTE)
public class NoteCRUDRepository extends AbstractCRUDRepository<Note> implements ICRUDRepository<Note> {

    public NoteCRUDRepository() {
        super("Note.getAll", "Note.count");
    }

    @Override
    protected Class<Note> getEntityClass() {
        return Note.class;
    }

}
