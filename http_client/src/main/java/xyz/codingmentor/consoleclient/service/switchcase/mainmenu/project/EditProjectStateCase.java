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
public class EditProjectStateCase extends AbstractCase {

    private final IHTTPRequest<ProjectDTO> httpRequest;
    private ProjectDTO projectDTO;

    public EditProjectStateCase() {
        super("Edit Project State", URLProperty.getURL("Projects.url"));
        this.httpRequest = new HTTPRequest<>(ProjectDTO.class);
    }

    @Override
    public void getInput() {
        Application.IO.out("Project id: ");
        projectDTO = httpRequest.get(getUrl() + Application.IO.getLong());
        Application.IO.outln(projectDTO.toString());
        Application.IO.out("New projectstate" + Arrays.asList(ProjectState.values()) + ": ");
        projectDTO.setProjectState(getProjectState());
    }

    @Override
    public void executeCase() {
        ProjectDTO responseProjectDTO = httpRequest.put(getUrl(), projectDTO);
        if (null != responseProjectDTO) {
            Application.IO.outln(responseProjectDTO.toString());
        } else {
            Application.IO.outln("Invalid data! Please try again.");
        }
        Application.IO.getString("Press any key to continue..");
    }

}
