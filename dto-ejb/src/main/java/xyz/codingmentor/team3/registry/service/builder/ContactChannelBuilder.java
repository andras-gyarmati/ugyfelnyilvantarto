package xyz.codingmentor.team3.registry.service.builder;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.contactchannel.ContactChannelDTO;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.CONTACTCHANNEL)
public class ContactChannelBuilder implements IBuilder<ContactChannelDTO, ContactChannel> {

    @Inject
    @CRUDServiceQualifier(EntityModel.PERSON)
    ICRUDService<Person> personCRUDService;

    @Override
    public ContactChannel buildEntity(ContactChannelDTO dto) {
        ContactChannel contactChannel = new ContactChannel();
        contactChannel.setId(dto.getId());
        contactChannel.setType(dto.getType());
        contactChannel.setContactChannelValue(dto.getContactChannelValue());
        try {
            contactChannel.setPerson(personCRUDService.getEntityById(dto.getPersonId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(ContactChannelBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactChannel;
    }

    @Override
    public ContactChannelDTO buildDTO(ContactChannel entity) {
        ContactChannelDTO contactChannelDTO = new ContactChannelDTO();
        contactChannelDTO.setId(entity.getId());
        contactChannelDTO.setType(entity.getType());
        contactChannelDTO.setContactChannelValue(entity.getContactChannelValue());
        contactChannelDTO.setPersonId(entity.getPerson().getId());
        return contactChannelDTO;
    }

}
