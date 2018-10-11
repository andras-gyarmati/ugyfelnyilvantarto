package xyz.codingmentor.team3.registry.dto.note;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class NoteDTO implements Serializable {

    private Long id;

    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String content;

    @NotNull
    private Long personId;

    @NotNull
    private Long eventId;

    public NoteDTO() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\ntitle=" + title
                + "\ncontent=" + content
                + "\npersonId=" + personId
                + "\neventId=" + eventId;
    }

}
