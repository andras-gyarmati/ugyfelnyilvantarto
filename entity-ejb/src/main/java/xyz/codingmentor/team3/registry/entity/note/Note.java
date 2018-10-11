package xyz.codingmentor.team3.registry.entity.note;

import xyz.codingmentor.team3.registry.entity.event.Event;
import java.io.Serializable;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlTransient;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Entity
@Validate
@Table(name = "note")
@NamedQueries({
    @NamedQuery(name = "Note.getAll", query = "FROM Note n"),
    @NamedQuery(name = "Note.count", query = "SELECT COUNT(n) FROM Note n")})
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String content;

    @JoinColumn(name = "person_id")
    @ManyToOne
    @NotNull
    private Person person;

    @JoinColumn(name = "event_id")
    @ManyToOne
    @NotNull
    private Event event;

    public Note() {
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

    @XmlTransient
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
