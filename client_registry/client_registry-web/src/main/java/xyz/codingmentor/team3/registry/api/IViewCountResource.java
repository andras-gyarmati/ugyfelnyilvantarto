package xyz.codingmentor.team3.registry.api;

import javax.ws.rs.GET;

/**
 *
 * @author brianelete
 */
public interface IViewCountResource {

    @GET
    public int getViewCount();

}
