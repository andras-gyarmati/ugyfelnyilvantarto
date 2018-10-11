package xyz.codingmentor.team3.registry.rest.viewcount;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.team3.registry.api.IViewCountResource;
import xyz.codingmentor.team3.registry.api.IViewCountService;

/**
 *
 * @author brianelete
 */
@Path("/viewcount")
public class ViewCountResource implements IViewCountResource {

    @Inject
    IViewCountService viewCount;

    @Override
    public int getViewCount() {
        return viewCount.get();
    }

}
