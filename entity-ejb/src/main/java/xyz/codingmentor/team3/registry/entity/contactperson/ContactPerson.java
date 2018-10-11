package xyz.codingmentor.team3.registry.entity.contactperson;

import xyz.codingmentor.team3.registry.entity.client.Client;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Tibor Kun
 */
@Entity
@Validate
@Table(name = "contact_person")
@DiscriminatorValue("C")
@NamedQueries({
    @NamedQuery(name = "ContactPerson.getAll", query = "FROM ContactPerson cp"),
    @NamedQuery(name = "ContactPerson.count", query = "SELECT COUNT(cp) FROM ContactPerson cp")})
public class ContactPerson extends Person implements Serializable {

    @ManyToOne
    @NotNull
    private Client client;

    public ContactPerson() {
        // nothing to initialize
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
