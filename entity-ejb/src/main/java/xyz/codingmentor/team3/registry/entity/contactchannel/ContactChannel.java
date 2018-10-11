package xyz.codingmentor.team3.registry.entity.contactchannel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Daróczi Kristóf
 */
@Entity
@Validate
@Table(name = "contact_channel")
@NamedQueries({
    @NamedQuery(name = "ContactChannel.getAll", query = "FROM ContactChannel ch"),
    @NamedQuery(name = "ContactChannel.count", query = "SELECT COUNT(ch) FROM ContactChannel ch")})
public class ContactChannel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactChannelType type;

    @Column(name = "contact_channel_value")
    @Size(max = 255)
    private String contactChannelValue;

    @ManyToOne
    @NotNull
    private Person person;

    public ContactChannel() {
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

    @XmlTransient
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
