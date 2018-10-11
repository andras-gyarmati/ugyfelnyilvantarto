package xyz.codingmentor.consoleclient.service.entitycreator;

import java.util.Arrays;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.io.EnumReader;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getContactChannelType;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getPositionType;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.team3.registry.dto.address.AddressDTO;
import xyz.codingmentor.team3.registry.dto.contactchannel.ContactChannelDTO;
import xyz.codingmentor.team3.registry.dto.contactperson.ContactPersonDTO;
import xyz.codingmentor.team3.registry.dto.invitation.InvitationDTO;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannelType;
import xyz.codingmentor.team3.registry.entity.invitation.InvitationStatus;
import xyz.codingmentor.team3.registry.entity.person.PositionType;

/**
 *
 * @author brianelete
 */
public class EntityCreator {

    private static final IHTTPRequest<AddressDTO> ADDRESSHTTPREQUEST = new HTTPRequest<>(AddressDTO.class);
    private static final IHTTPRequest<ContactPersonDTO> CPERSONHTTPREQUEST = new HTTPRequest<>(ContactPersonDTO.class);
    private static final IHTTPRequest<ContactChannelDTO> CCHANNELHTTPREQUEST = new HTTPRequest<>(ContactChannelDTO.class);
    private static final IHTTPRequest<InvitationDTO> INVITATIONHTTPREQUEST = new HTTPRequest<>(InvitationDTO.class);

    private EntityCreator() {
        // hide the implicit constructor
    }

    public static Long getAddress() {
        Application.IO.out("address id or '0' to create new: ");
        Long id = Application.IO.getLong();
        if (0L == id) {
            return createAddress();
        }
        return id;
    }

    public static Long createAddress() {
        AddressDTO addressDTO = new AddressDTO();
        Application.IO.out("country: ");
        addressDTO.setCountry(Application.IO.getString());
        Application.IO.out("state: ");
        addressDTO.setState(Application.IO.getString());
        Application.IO.out("city: ");
        addressDTO.setCity(Application.IO.getString());
        Application.IO.out("street: ");
        addressDTO.setStreet(Application.IO.getString());
        Application.IO.out("zip: ");
        addressDTO.setZipCode(Application.IO.getString());
        addressDTO = ADDRESSHTTPREQUEST.post(URLProperty.getURL("Addresses.url"), addressDTO);
        return addressDTO.getId();
    }

    public static Long getContactPerson(Long clientId) {
        Application.IO.out("contactperson id or '0' to create new: ");
        Long id = Application.IO.getLong();
        if (0L == id) {
            return createContactPerson(clientId);
        }
        return id;
    }

    public static Long createContactPerson(Long clientId) {
        ContactPersonDTO contactPersonDTO = new ContactPersonDTO();
        Application.IO.out("Firstname: ");
        contactPersonDTO.setFirstName(Application.IO.getString());
        Application.IO.out("Lastname: ");
        contactPersonDTO.setLastName(Application.IO.getString());
        Application.IO.out("Position" + Arrays.asList(PositionType.values()) + ": ");
        contactPersonDTO.setPosition(getPositionType());
        Application.IO.out("Profil picturepath: ");
        contactPersonDTO.setProfilePicturePath(Application.IO.getString());
        contactPersonDTO.setClientId(clientId);
        contactPersonDTO = CPERSONHTTPREQUEST.post(URLProperty.getURL("ContactPeople.url"), contactPersonDTO);
        getContactChannel(contactPersonDTO.getId());
        return contactPersonDTO.getId();
    }

    public static Long getContactChannel(Long personId) {
        Application.IO.out("contactchannel id or '0' to create new: ");
        Long id = Application.IO.getLong();
        if (0L == id) {
            return createContactChannel(personId);
        }
        return id;
    }

    public static Long createContactChannel(Long personId) {
        ContactChannelDTO contactChannelDTO = new ContactChannelDTO();
        Application.IO.out("contactchannel type " + Arrays.asList(ContactChannelType.values()) + ": ");
        contactChannelDTO.setType(getContactChannelType());
        Application.IO.out("value: ");
        contactChannelDTO.setContactChannelValue(Application.IO.getString());
        contactChannelDTO.setPersonId(personId);
        contactChannelDTO = CCHANNELHTTPREQUEST.post(URLProperty.getURL("ContactChannels.url"), contactChannelDTO);
        return contactChannelDTO.getId();
    }

    public static Long getInvitation(Long eventId) {
        Application.IO.out("'s' for skip or 'n' to create new invitation: ");
        String isNew = Application.IO.getString();
        while (!"s".equals(isNew)) {
            if ("n".equals(isNew)) {
                return createInvitation(eventId);
            }
            Application.IO.outln("wrong input!");
        }
        return null;
    }

    public static Long createInvitation(Long eventId) {
        InvitationDTO invitationDTO = new InvitationDTO();
        Application.IO.out("description: ");
        invitationDTO.setDescription(Application.IO.getString());
        Application.IO.out("status " + Arrays.asList(InvitationStatus.values()) + ": ");
        invitationDTO.setStatus(EnumReader.getInvitationStatus());
        invitationDTO.setEventId(eventId);
        invitationDTO = INVITATIONHTTPREQUEST.post(URLProperty.getURL("Invitations.url"), invitationDTO);
        return invitationDTO.getId();
    }

}
