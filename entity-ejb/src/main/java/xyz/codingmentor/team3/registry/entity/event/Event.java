package xyz.codingmentor.team3.registry.entity.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.invitation.Invitation;
import xyz.codingmentor.team3.registry.entity.note.Note;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Entity
@Validate
@Table(name = "event_table")
@NamedQueries({
    @NamedQuery(name = "Event.countAddress", query = "SELECT COUNT(e.id) FROM Event e INNER JOIN e.address a WHERE a.id = :addressId"),
    @NamedQuery(name = "Event.getAll", query = "FROM Event e"),
    @NamedQuery(name = "Event.count", query = "SELECT COUNT(e) FROM Event e")})
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType type;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "finish_date")
    @Temporal(TemporalType.DATE)
    private Date finishDate;

    @Column(name = "event_name")
    @Size(max = 255)
    private String eventName;

    @JoinColumn(name = "client_id")
    @ManyToOne
    @NotNull
    private Client client;

    @JoinColumn(name = "address_id")
    @OneToOne
    @NotNull
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Note> notes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Invitation> invitations;

    public Event() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlTransient
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @XmlTransient
    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    @PreRemove
    private void preRemove() {
        address = null;
    }

}
