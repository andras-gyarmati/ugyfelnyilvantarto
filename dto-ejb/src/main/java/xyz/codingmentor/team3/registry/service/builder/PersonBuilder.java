package xyz.codingmentor.team3.registry.service.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.person.PersonDTO;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.PERSON)
public class PersonBuilder implements IBuilder<PersonDTO, Person> {

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTCHANNEL)
    ICRUDService<ContactChannel> contactChannelCRUDService;

    @Override
    public Person buildEntity(PersonDTO dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setPosition(dto.getPosition());
        person.setProfilePicturePath(dto.getProfilePicturePath());
        person.setContactChannels(readContactChannels(dto));
        return person;
    }

    @Override
    public PersonDTO buildDTO(Person entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(entity.getId());
        personDTO.setFirstName(entity.getFirstName());
        personDTO.setLastName(entity.getLastName());
        personDTO.setPosition(entity.getPosition());
        personDTO.setProfilePicturePath(entity.getProfilePicturePath());
        personDTO.setContactChannelIdList(readContactChannels(entity));
        return personDTO;
    }

    private List<ContactChannel> readContactChannels(PersonDTO dto) {
        List<ContactChannel> contactChannels = new ArrayList();
        if (null != dto.getContactChannelIdList()) {
            dto.getContactChannelIdList().forEach((contactChannelId) -> {
                try {
                    contactChannels.add(contactChannelCRUDService.getEntityById(contactChannelId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(PersonBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return contactChannels;
    }

    private List<Long> readContactChannels(Person entity) {
        List<Long> contactChannelIdList = new ArrayList();
        if (null != entity.getContactChannels()) {
            entity.getContactChannels().forEach((contactChannel) -> {
                contactChannelIdList.add(contactChannel.getId());
            });
        }
        return contactChannelIdList;
    }

}
