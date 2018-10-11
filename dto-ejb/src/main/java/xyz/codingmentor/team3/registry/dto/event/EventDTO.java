package xyz.codingmentor.team3.registry.dto.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.entity.event.EventType;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class EventDTO implements Serializable {

    private Long id;
    private EventType type;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date finishDate;

    @Size(max = 255)
    private String eventName;

    @NotNull
    private Long clientId;

    @NotNull
    private Long addressId;

    private List<Long> noteIdList;
    private List<Long> invitationIdList;

    public EventDTO() {
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Long> getNoteIdList() {
        return noteIdList;
    }

    public void setNoteIdList(List<Long> noteIdList) {
        this.noteIdList = noteIdList;
    }

    public List<Long> getInvitationIdList() {
        return invitationIdList;
    }

    public void setInvitationIdList(List<Long> invitationIdList) {
        this.invitationIdList = invitationIdList;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\ntype=" + type
                + "\nstartDate=" + startDate
                + "\nfinishDate=" + finishDate
                + "\neventName=" + eventName
                + "\nclientId=" + clientId
                + "\naddressId=" + addressId
                + "\nnoteIdList=" + noteIdList
                + "\ninvitationIdList=" + invitationIdList;
    }

}
