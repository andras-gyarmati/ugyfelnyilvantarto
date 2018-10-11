package xyz.codingmentor.team3.registry.entity.invitation;

import xyz.codingmentor.team3.registry.entity.event.Event;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Entity
@Validate
@Table(name = "invitation")
@NamedQueries({
    @NamedQuery(name = "Invitation.getAll", query = "FROM Invitation i"),
    @NamedQuery(name = "Invitation.count", query = "SELECT COUNT(i) FROM Invitation i")})
public class Invitation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String description;

    @JoinColumn(name = "event_id")
    @ManyToOne
    @NotNull
    private Event event;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;

    public Invitation() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }

}
