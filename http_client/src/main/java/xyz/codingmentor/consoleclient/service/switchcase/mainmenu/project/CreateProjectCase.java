package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project;

import java.util.Arrays;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import static xyz.codingmentor.consoleclient.service.io.EnumReader.getProjectState;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;
import xyz.codingmentor.team3.registry.entity.project.ProjectState;

/**
 *
 * @author brianelete
 */
public class CreateProjectCase extends AbstractCase {

    private final IHTTPRequest<ProjectDTO> httpRequest;
    private ProjectDTO projectDTO;

    public CreateProjectCase() {
        super("Create Project", URLProperty.getURL("Projects.url"));
        this.httpRequest = new HTTPRequest<>(ProjectDTO.class);
        this.projectDTO = new ProjectDTO();
    }

    @Override
    public void getInput() {
        projectDTO = new ProjectDTO();
        Application.IO.out("Project name: ");
        projectDTO.setProjectName(Application.IO.getString());
        Application.IO.out("Deadline: ");
        projectDTO.setDeadline(Application.IO.getDate());
        Application.IO.out("Projectstate" + Arrays.asList(ProjectState.values()) + ": ");
        projectDTO.setProjectState(getProjectState());
        Application.IO.out("Client id: ");
        projectDTO.setClientId(Application.IO.getLong());
    }

    @Override
    public void executeCase() {
        projectDTO = httpRequest.post(getUrl(), projectDTO);
        if (null != projectDTO) {
            Application.IO.outln("Project " + projectDTO.getProjectName() + " successfully saved!");
            ProjectDTO responseProjectDTO = httpRequest.get(getUrl() + projectDTO.getId());
            if (null != responseProjectDTO) {
                Application.IO.outln(responseProjectDTO.toString());
            }
        } else {
            Application.IO.outln("Invalid data! Please try again.");
        }
        Application.IO.getString("Press any key to continue..");
    }

}
