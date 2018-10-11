package xyz.codingmentor.team3.registry.entity.client;

import xyz.codingmentor.team3.registry.entity.address.Address;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author Daróczi Kristóf
 */
@Entity
@Validate
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.countAddress", query = "SELECT COUNT(c.id) FROM Client c INNER JOIN c.address a WHERE a.id = :addressId"),
    @NamedQuery(name = "Client.getAll", query = "FROM Client c"),
    @NamedQuery(name = "Client.count", query = "SELECT COUNT(c) FROM Client c")})
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @Column(name = "tax_number")
    @NotNull
    @Size(max = 255)
    private String taxNumber;

    @Size(max = 255)
    private String logo;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ContactPerson> contactPeople;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Project> projects;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Event> events;

    public Client() {
        // empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlTransient
    public List<ContactPerson> getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(List<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;
    }

    @XmlTransient
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @XmlTransient
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @PreRemove
    private void preRemove() {
        address = null;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", taxNumber=" + taxNumber + ", logo=" + logo + ", address=" + address + '}';
    }

}
