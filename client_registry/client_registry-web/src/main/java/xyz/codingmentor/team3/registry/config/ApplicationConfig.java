package xyz.codingmentor.team3.registry.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Tibor Kun
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.team3.registry.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.team3.registry.exception.RemoveAdminExceptionMapper.class);
        resources.add(xyz.codingmentor.team3.registry.exception.RepositoryExceptionMapper.class);
        resources.add(xyz.codingmentor.team3.registry.exception.ValidationExceptionMapper.class);
        resources.add(xyz.codingmentor.team3.registry.rest.auth.AuthenticationRESTService.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.AddressCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.ClientCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.ContactChannelCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.ContactPersonCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.EventCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.InvitationCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.NoteCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.PersonCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.ProjectCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.RoleCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.crud.specific.UserCRUDResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.event.EventResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.project.ProjectResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.query.QueryResource.class);
        resources.add(xyz.codingmentor.team3.registry.rest.user.UserRESTService.class);
        resources.add(xyz.codingmentor.team3.registry.rest.viewcount.ViewCountResource.class);
    }

}
