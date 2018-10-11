package xyz.codingmentor.team3.registry.dto.person;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.entity.person.PositionType;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class PersonDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;
    
    private PositionType position;

    @Size(max = 255)
    private String profilePicturePath;
    private List<Long> contactChannelIdList;

    public PersonDTO() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public List<Long> getContactChannelIdList() {
        return contactChannelIdList;
    }

    public void setContactChannelIdList(List<Long> contactChannelIdList) {
        this.contactChannelIdList = contactChannelIdList;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\nfirstName: " + firstName
                + "\nlastName: " + lastName
                + "\nposition: " + position
                + "\nprofilePicturePath: " + profilePicturePath
                + "\ncontactChannelIdList: " + contactChannelIdList;
    }

}
