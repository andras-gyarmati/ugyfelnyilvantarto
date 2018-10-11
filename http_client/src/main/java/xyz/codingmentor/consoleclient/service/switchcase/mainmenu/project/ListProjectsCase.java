package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.project;

import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.pager.Pager;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.project.ProjectDTO;

/**
 *
 * @author brianelete
 */
public class ListProjectsCase extends AbstractCase {

    private IPager pager;

    public ListProjectsCase() {
        super("List Projects", URLProperty.getURL("Projects.url"));
    }

    @Override
    public void executeCase() {
        pager = new Pager(ProjectDTO.class, caseMsg());
        pager.printList(getUrl());
    }

}
