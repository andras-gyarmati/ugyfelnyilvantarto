package xyz.codingmentor.team3.registry.dto.invitation;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.entity.invitation.InvitationStatus;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class InvitationDTO implements Serializable {

    private Long id;

    @Size(max = 255)
    private String description;

    @NotNull
    private Long eventId;

    private InvitationStatus status;

    public InvitationDTO() {
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\ndescription=" + description
                + "\neventId=" + eventId
                + "\nstatus=" + status;
    }

}
