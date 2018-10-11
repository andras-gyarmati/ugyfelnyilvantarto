package xyz.codingmentor.team3.registry.service.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.contactperson.ContactPersonDTO;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.CONTACTPERSON)
public class ContactPersonBuilder implements IBuilder<ContactPersonDTO, ContactPerson> {

    @Inject
    @CRUDServiceQualifier(EntityModel.CLIENT)
    ICRUDService<Client> clientCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTCHANNEL)
    ICRUDService<ContactChannel> contactChannelCRUDService;

    @Override
    public ContactPerson buildEntity(ContactPersonDTO dto) {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId(dto.getId());
        contactPerson.setFirstName(dto.getFirstName());
        contactPerson.setLastName(dto.getLastName());
        contactPerson.setPosition(dto.getPosition());
        contactPerson.setProfilePicturePath(dto.getProfilePicturePath());
        contactPerson.setContactChannels(readContactChannels(dto));
        try {
            contactPerson.setClient(clientCRUDService.getEntityById(dto.getClientId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(ContactPersonBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactPerson;
    }

    @Override
    public ContactPersonDTO buildDTO(ContactPerson entity) {
        ContactPersonDTO contactPersonDTO = new ContactPersonDTO();
        contactPersonDTO.setId(entity.getId());
        contactPersonDTO.setFirstName(entity.getFirstName());
        contactPersonDTO.setLastName(entity.getLastName());
        contactPersonDTO.setPosition(entity.getPosition());
        contactPersonDTO.setProfilePicturePath(entity.getProfilePicturePath());
        contactPersonDTO.setContactChannelIdList(readContactChannels(entity));
        contactPersonDTO.setClientId(entity.getClient().getId());
        return contactPersonDTO;
    }

    private List<ContactChannel> readContactChannels(ContactPersonDTO dto) {
        List<ContactChannel> contactChannels = new ArrayList();
        if (null != dto.getContactChannelIdList()) {
            dto.getContactChannelIdList().forEach((contactChannelId) -> {
                try {
                    contactChannels.add(contactChannelCRUDService.getEntityById(contactChannelId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(ContactPersonBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return contactChannels;
    }

    private List<Long> readContactChannels(ContactPerson entity) {
        List<Long> contactChannelIdList = new ArrayList();
        if (null != entity.getContactChannels()) {
            entity.getContactChannels().forEach((contactChannel) -> {
                contactChannelIdList.add(contactChannel.getId());
            });
        }
        return contactChannelIdList;
    }

}
