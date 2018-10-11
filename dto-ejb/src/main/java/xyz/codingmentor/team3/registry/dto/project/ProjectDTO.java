package xyz.codingmentor.team3.registry.dto.project;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.entity.project.ProjectState;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class ProjectDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String projectName;

    @Temporal(TemporalType.DATE)
    private Date deadline;
    private ProjectState projectState;

    @NotNull
    private Long clientId;

    public ProjectDTO() {
        // empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public ProjectState getProjectState() {
        return projectState;
    }

    public void setProjectState(ProjectState projectState) {
        this.projectState = projectState;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\nprojectName=" + projectName
                + "\ndeadline=" + deadline
                + "\nprojectState=" + projectState
                + "\nclientId=" + clientId;
    }

}
