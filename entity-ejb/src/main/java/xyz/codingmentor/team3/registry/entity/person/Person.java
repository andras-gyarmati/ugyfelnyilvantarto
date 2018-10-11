package xyz.codingmentor.team3.registry.entity.person;

import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Tibor Kun
 */
@Entity
@Validate
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@DiscriminatorValue("P")
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.getAll", query = "FROM Person p"),
    @NamedQuery(name = "Person.count", query = "SELECT COUNT(p) FROM Person p")})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(max = 255)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 255)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private PositionType position;

    @Column(name = "profile_picture_path")
    @Size(max = 255)
    private String profilePicturePath;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ContactChannel> contactChannels;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Note> notes;

    public Person() {
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

    public List<ContactChannel> getContactChannels() {
        return contactChannels;
    }

    public void setContactChannels(List<ContactChannel> contactChannels) {
        this.contactChannels = contactChannels;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
