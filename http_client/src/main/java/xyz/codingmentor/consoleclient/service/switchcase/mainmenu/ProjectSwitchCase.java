package xyz.codingmentor.consoleclient.service.switchcase.mainmenu;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitchCase;
import xyz.codingmentor.consoleclient.service.switchcase.BackCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project.CreateProjectCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project.EditProjectStateCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project.ListProjectsCase;
import xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project.RemoveProjectCase;

/**
 *
 * @author brianelete
 */
public class ProjectSwitchCase extends AbstractSwitchCase {

    public ProjectSwitchCase() {
        super("Project");
    }

    @Override
    public void fillCases() {
        addCase(new BackCase("Back", this));
        addCase(new ListProjectsCase());
        addCase(new CreateProjectCase());
        addCase(new EditProjectStateCase());
        addCase(new RemoveProjectCase());
    }

}
