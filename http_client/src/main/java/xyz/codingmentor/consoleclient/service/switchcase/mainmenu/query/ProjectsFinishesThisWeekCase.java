package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.query;

import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;

/**
 *
 * @author brianelete
 */
public class ProjectsFinishesThisWeekCase extends AbstractCase {

    private IPager pager;

    public ProjectsFinishesThisWeekCase() {
        super("Those projects which have a deadline for this week", URLProperty.getURL("Projectsthisweek.url"));
    }

    @Override
    public String getSeparator() {
        return "\n";
    }

    @Override
    public void executeCase() {
        pager = new Pager(ProjectDTO.class, caseMsg());
        pager.printList(getUrl());
    }

}
