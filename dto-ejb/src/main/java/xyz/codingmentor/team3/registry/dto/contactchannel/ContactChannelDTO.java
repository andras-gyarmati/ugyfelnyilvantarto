package xyz.codingmentor.team3.registry.dto.contactchannel;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannelType;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class ContactChannelDTO implements Serializable {

    private Long id;
    private ContactChannelType type;

    @Size(max = 255)
    private String contactChannelValue;

    @NotNull
    private Long personId;

    public ContactChannelDTO() {
        // empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactChannelType getType() {
        return type;
    }

    public void setType(ContactChannelType type) {
        this.type = type;
    }

    public String getContactChannelValue() {
        return contactChannelValue;
    }

    public void setContactChannelValue(String contactChannelValue) {
        this.contactChannelValue = contactChannelValue;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\ntype=" + type
                + "\ncontactChannelValue=" + contactChannelValue
                + "\npersonId=" + personId;
    }

}
